package ec.edu.uce.aplication.service;
import ec.edu.uce.domain.model.Mail;
import ec.edu.uce.infraestructure.repository.MailRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MailService {
    @Inject
    private MailRepositoryImpl mailRepositoryImpl;
    
    @MedirTiempo
    public void guardar(Mail mail){
        String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre el hilo MailService" + nombrehilo);
        System.out.println("ID:" + Thread.currentThread().threadId());
        this.mailRepositoryImpl.persist(mail);
    }
    public Mail buscarId(Integer id){
      // return this.mailRepositoryImpl.findById(id);
      return Mail.findById(id);
    }
}