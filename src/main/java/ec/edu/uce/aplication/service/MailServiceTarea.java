package ec.edu.uce.aplication.service;

import ec.edu.uce.domain.model.Mail;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Dependent
public class MailServiceTarea implements Runnable{

    @Inject
    private MailService mailService; 

    private Mail mail;
    //metodo implementado mediante la interface runable 

  
    public MailServiceTarea(){

    }

    @Override

    public void run() {
       System.out.println("Nombre de hilo mail:" + Thread.currentThread().getName());    
       this.mailService.guardar(this.mail);
    }

    public MailService getMailService() {
        return mailService;
    }


    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }




}
