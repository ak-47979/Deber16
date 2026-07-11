package ec.edu.uce.aplication.service;

import java.util.List;

import ec.edu.uce.domain.model.Reporte;
import ec.edu.uce.infraestructure.repository.ReporteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional

@MedirTiempo
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl reporteRepositoryImpl;

    @MedirTiempo
    public void guardar(Reporte reporte) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo REPORTESERVICE: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
/*
        try {
            Thread.sleep(0);
        } catch (Exception e) {
            System.err.println("Error en sleep: " + e.getMessage());
        }*/

        this.reporteRepositoryImpl.persist(reporte);
    }

    @Auditar
    public void guardarLisParalelo(List<Reporte> lista) {
      lista.parallelStream().forEach(rep->{
         this.reporteRepositoryImpl.persist(rep);
      });  
    }

     @Auditar
    public void guardarLis(List<Reporte> lista) {
     
        String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre el hilo ReporteService" + nombrehilo);
        System.out.println("ID:" + Thread.currentThread().threadId());
        this.reporteRepositoryImpl.persist(lista);
    }
    public Reporte buscarId(Integer id) {
        //return this.reporteRepositoryImpl.findById(id);
        return Reporte.findById(id);
    }

}
