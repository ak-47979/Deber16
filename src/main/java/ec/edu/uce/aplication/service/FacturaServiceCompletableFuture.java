package ec.edu.uce.aplication.service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

import ec.edu.uce.domain.model.Factura;
import ec.edu.uce.domain.model.Mail;
import ec.edu.uce.domain.model.Reporte;
import ec.edu.uce.infraestructure.repository.FacturaRespositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class FacturaServiceCompletableFuture {

    @Inject
    private FacturaRespositoryImpl facturaRespositoryImpl;

    @Inject
    private MailService mailService;

    @Inject
    public ReporteService reporteService;

    @MedirTiempo
    @Transactional
    public void guardarF(Factura factura) {
        String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre el hilo FacturaService" + nombrehilo);
        System.out.println("ID:" + Thread.currentThread().threadId());
        this.facturaRespositoryImpl.persist(factura);

        Reporte repo = new Reporte();
        repo.setAutor("Andy");
        repo.setTitulo("Reporte");
        repo.setDescripcion("autos vendidos: 3");
        repo.setFecha(LocalDate.now());


        CompletableFuture<Void> completableReporte =
        CompletableFuture.runAsync(()->this.reporteService.guardar(repo));
      //  this.reporteService.guardar(repo);



        Mail mail = new Mail();
        mail.setRemitente("Andy");
        mail.setDestinatario("Paul");
        mail.setMensaje("se vendio tre autos");
            
        mail.setFecha(LocalDate.now());

        CompletableFuture<Void> completableMail =
        CompletableFuture.runAsync(()->this.mailService.guardar(mail));
 //  this.mailService.guardar(mail);


        CompletableFuture.allOf(completableReporte,completableMail).join();
     

    }
}