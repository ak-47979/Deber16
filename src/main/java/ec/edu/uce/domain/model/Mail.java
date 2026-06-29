package ec.edu.uce.domain.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "mail")
public class Mail extends PanacheEntityBase{
    @SequenceGenerator(name="seq_mail_generador",sequenceName="seq_mail",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="seq_mail_generador")
     @Id
     @Column(name="fact_id")
    private Integer id;
    private String remitente;
    private String destinatario;
    private String asunto;
    private String mensaje;
    private LocalDate fecha;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getRemitente() {
        return remitente;
    }
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    @Override
    public String toString() {
        return "Mail [id=" + id + ", remitente=" + remitente + ", destinatario=" + destinatario + ", asunto=" + asunto
                + ", mensaje=" + mensaje + ", fecha=" + fecha + "]";
    }

}