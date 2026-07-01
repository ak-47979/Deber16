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

     public void guardar(Mail mail){
        this.mailRepositoryImpl.persist(mail);
     }
    public Mail buscarId(Integer id){
      // return this.mailRepositoryImpl.findById(id);
      return Mail.findById(id);
    }
}
