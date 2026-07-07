package ec.edu.uce.aplication.service;



import java.time.LocalDate;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ec.edu.uce.domain.model.Factura;
import ec.edu.uce.domain.model.Mail;
import ec.edu.uce.domain.model.Reporte;
import ec.edu.uce.infraestructure.repository.FacturaRespositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;


@ApplicationScoped
@Transactional
public class FacturaServiceParalelo {
    
@Inject
private FacturaRespositoryImpl facturaRespositoryImpl;

    @Inject
    public ReporteService reporteService;

    @Inject
    public MailService mailService;
    
    @Inject
    public MailServiceTarea mailServiceTarea;

    @Inject
    private ReporteServiceTarea reporteServiceTarea;
  
    @MedirTiempo
    public void guardar(Factura factura) throws ExecutionException, InterruptedException{
         String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre el hilo FacturaServiceParalela" + nombrehilo);
        System.out.println("ID:" + Thread.currentThread().threadId());
        this.facturaRespositoryImpl.persist(factura);
        
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        
        Reporte repo = new Reporte();
        
        repo.setAutor("Andy");
        repo.setTitulo("Reporte");
        repo.setDescripcion("autos vendidos: 3");
        repo.setFecha(LocalDate.now());       
       // this.reporteService.guardar(repo);
       //se envia a guardar el reporte a ejecutar en forma paralela
       this.reporteServiceTarea.setReporte(repo);
      // ReporteServiceTarea reporteServiceTarea = new ReporteServiceTarea(repo,reporteService);
      
       Future<?>  repoFuture= executorService.submit(reporteServiceTarea);

   


       //-------------------------------
        Mail mail = new Mail();
        mail.setRemitente("Andy");
        mail.setDestinatario("Paul");
        mail.setMensaje("se vendio tre autos");
        mail.setFecha(LocalDate.now());
        //this.mailService.guardar(mail);
        //se envia a guardar el mail a ejecutar en forma paralela
       
        //MailServiceTarea mailServiceTarea = new MailServiceTarea(mail );
        this.mailServiceTarea.setMail(mail);

        Future<?>  mailFuture= executorService.submit(mailServiceTarea);
       
          //tiene que terminarse la tarea del reporte
        repoFuture.get();
         //tiene que terminarse la tarea del reporte
        mailFuture.get();
           //Cerra el proceso de ejcucion, indicando que no se va a enviar mas tareas
        executorService.shutdown();
      
       

    }
}
