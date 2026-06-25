package ec.edu.uce.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="transferencia")
public class Transferencia {
    @SequenceGenerator(name="seq_transferencia_generador",sequenceName="seq_transferencia",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_transferencia_generador")
    @Id
    @Column(name="tran_id")
    private Integer id;
 
    @Column(name="tran_monto")
    private BigDecimal monto;
    @Column(name="tran_fecha")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "tran_origen")
    private Cuenta cuentaOrigen;

    @ManyToOne
    @JoinColumn(name = "tran_destino")
    private Cuenta cuentaDestino;

     
    
      
      public Transferencia(){

      }

    public Transferencia(Cuenta cuentaDestino, Cuenta cuentaOrigen, LocalDate fecha, BigDecimal monto) {
        this.cuentaDestino = cuentaDestino;
        this.cuentaOrigen = cuentaOrigen;
        this.fecha = fecha;
        this.monto = monto;
    }
      public Integer getId() {
          return id;
      }
      public void setId(Integer id) {
          this.id = id;
      }
      public BigDecimal getMonto() {
          return monto;
      }
      public void setMonto(BigDecimal monto) {
          this.monto = monto;
      }
      public Cuenta getCuentaOrigen() {
          return cuentaOrigen;
      }
      public void setCuentaOrigen(Cuenta cuentaOrigen) {
          this.cuentaOrigen = cuentaOrigen;
      }
      public Cuenta getCuentaDestino() {
          return cuentaDestino;
      }
      public void setCuentaDestino(Cuenta cuentaDestino) {
          this.cuentaDestino = cuentaDestino;
      }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transferencia{");
        sb.append("id=").append(id);
        sb.append(", monto=").append(monto);
        sb.append(", cuentaOrigen=").append(cuentaOrigen);
        sb.append(", cuentaDestino=").append(cuentaDestino);
        sb.append('}');
        return sb.toString();
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
     

    
}