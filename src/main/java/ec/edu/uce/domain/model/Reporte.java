package ec.edu.uce.domain.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@ApplicationScoped
@Table(name = "reporte")
public class Reporte extends PanacheEntityBase{
    @SequenceGenerator(name = "seq_reporte_generador",sequenceName = "seq_reporte",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reporte_generador")
    @Id
    @Column(name = "repo_id")
    private Integer id;
     @Column(name = "repo_titulo")
     private String titulo;
     @Column(name = "repo_descripcion")
    private String descripcion;
    @Column(name = "repo_fecha")
    private LocalDate fecha;
    @Column(name = "repo_autor")
    private String autor;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Reporte [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fecha=" + fecha
                + ", autor=" + autor + "]";
    }



}
