package ec.edu.uce.aplication.service;

import java.time.LocalDate;

import ec.edu.uce.domain.model.Factura;
import ec.edu.uce.domain.model.Mail;
import ec.edu.uce.domain.model.Reporte;
import ec.edu.uce.infraestructure.repository.FacturaRespositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class FacturaService {

    @Inject
    private FacturaRespositoryImpl facturaRespositoryImpl;

    @MedirTiempo
    public void guardar(Factura factura){
         String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre el hilo FacturaService" + nombrehilo);
        System.out.println("ID:" + Thread.currentThread().threadId());
        this.facturaRespositoryImpl.persist(factura);
    }
    public Factura buscarId(Integer id){
       // return this.facturaRespositoryImpl.findById(id);
        return Factura.findById(id);
    }

   

    @Inject
    private MailService mailService;

    @Inject
    public ReporteService reporteService;

    @MedirTiempo
    public void guardarF(Factura factura){
         String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre el hilo FacturaService" + nombrehilo);
        System.out.println("ID:" + Thread.currentThread().threadId());
        this.facturaRespositoryImpl.persist(factura);
        
        Reporte repo = new Reporte();
        repo.setAutor("Andy");
        repo.setTitulo("Reporte");
        repo.setDescripcion("autos vendidos: 3");
        repo.setFecha(LocalDate.now());       
        this.reporteService.guardar(repo);


        Mail mail = new Mail();
        mail.setRemitente("Andy");
        mail.setDestinatario("Paul");
        mail.setMensaje("se vendio tre autos");
        mail.setFecha(LocalDate.now());
        this.mailService.guardar(mail);

    }
}
