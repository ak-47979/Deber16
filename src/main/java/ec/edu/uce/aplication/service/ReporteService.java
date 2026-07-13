package ec.edu.uce.aplication.service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.IntStream;

import ec.edu.uce.domain.model.Reporte;
import ec.edu.uce.infraestructure.repository.ReporteRepositoryImpl;
import io.quarkus.narayana.jta.QuarkusTransaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional

@MedirTiempo
public class ReporteService {
    @Inject
    EntityManager em;

    @Inject
    private ReporteRepositoryImpl reporteRepositoryImpl;

    @MedirTiempo
    public void guardar(Reporte reporte) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo REPORTESERVICE: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
        /*
         * try {
         * Thread.sleep(0);
         * } catch (Exception e) {
         * System.err.println("Error en sleep: " + e.getMessage());
         * }
         */

        this.reporteRepositoryImpl.persist(reporte);
    }

   

    @Auditar
    @Transactional
    public void guardarLis(List<Reporte> lista) {

        String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre el hilo ReporteService" + nombrehilo);
        System.out.println("ID:" + Thread.currentThread().threadId());
         int i = 0;

    for (Reporte p : lista) {
        p.persist();

        if (++i % 1000 == 0) {
            em.flush();
            em.clear();
        }
    }
    }
     @Auditar
  
    public void guardarLisParalelo(List<Reporte> lista) {

        Instant start = Instant.now();
        System.out.println("Iniciando inserción PARALELA de " + lista.size() + " registros...");

        lista.parallelStream().forEach(rep -> {
            try {
                QuarkusTransaction.requiringNew().run(() -> {
                    rep.persist();
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("Tiempo total: " + duration + " ms");
    }

    public Reporte buscarId(Integer id) {
        // return this.reporteRepositoryImpl.findById(id);
        return Reporte.findById(id);
    }

}
