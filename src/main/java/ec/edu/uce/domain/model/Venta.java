package ec.edu.uce.domain.model;

import java.math.BigDecimal;
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
@Table(name = "venta")
public class Venta extends PanacheEntityBase{
    @SequenceGenerator(name = "seq_venta_generador", sequenceName = "seq_venta", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_venta_generador")
    @Id

    @Column(name = "vent_id")
    private Integer id;

    @Column(name = "vent_cliente")
    private String cliente;

    @Column(name = "vent_fecha")
    private LocalDate fecha;

    @Column(name = "vent_total")
    private BigDecimal total;

    public Integer getId() {
        return id;
    }
    public Venta(){

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    @Override
    public String toString() {
        return "Venta [id=" + id + ", cliente=" + cliente + ", fecha=" + fecha + ", total=" + total + "]";
    }
    
}