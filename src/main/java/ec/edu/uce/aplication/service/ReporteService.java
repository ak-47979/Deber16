package ec.edu.uce.aplication.service;


import ec.edu.uce.domain.model.Reporte;
import ec.edu.uce.infraestructure.repository.ReporteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ReporteService {
    @Inject
    private ReporteRepositoryImpl reporteRepositoryImpl;
     @MedirTiempo
     public void guardar(Reporte reporte){
        String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre el hilo ReporteService" + nombrehilo);
        System.out.println("ID:" + Thread.currentThread().threadId());
        this.reporteRepositoryImpl.persist(reporte);
     }
 
     public Reporte buscarId(Integer id){
        //return this.reporteRepositoryImpl.findById(id);
        return Reporte.findById(id);
    }

}