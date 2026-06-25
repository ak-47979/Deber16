package ec.edu.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class Mail {
    @SequenceGenerator(name="seq_mail_generador",sequenceName="seq_factura",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="seq_mail_generador")
     @Id
     @Column(name="fact_id")
    private Integer id;
}
