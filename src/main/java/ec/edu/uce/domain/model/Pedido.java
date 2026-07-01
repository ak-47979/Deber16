package ec.edu.uce.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido extends PanacheEntityBase {
    @SequenceGenerator(name = "seq_pedido_generador", sequenceName = "seq_pedido",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_pedido")
    @Id
    @Column(name = "pedi_id")
    private Integer id;
    @Column(name = "pedi_cliente")
    private String cliente;
    @Column(name = "pedi_total")
    private double total;

    public Pedido(){
        
    }

    public Pedido(String cliente, double total) {
        this.cliente = cliente;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", cliente=" + cliente + ", total=" + total + "]";
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }



    public String getCliente() {
        return cliente;
    }


    public void setCliente(String cliente) {
        this.cliente = cliente;
    }



    public double getTotal() {
        return total;
    }


    public void setTotal(double total) {
        this.total = total;
    }


}