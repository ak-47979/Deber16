package ec.edu.uce.aplication.service;

import ec.edu.uce.domain.model.Mail;


public class MailServiceTarea implements Runnable{

    
    private MailService mailService; 

    private Mail mail;
    //metodo implementado mediante la interface runable 

    public MailServiceTarea(Mail mail, MailService mailService) {
        this.mail = mail;
    }
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

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }



}
