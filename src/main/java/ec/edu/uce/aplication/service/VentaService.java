package ec.edu.uce.aplication.service;

import io.quarkus.narayana.jta.QuarkusTransaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import ec.edu.uce.domain.model.Venta;

@ApplicationScoped
public class VentaService {

    @Inject
    AuditoriaService auditoriaService;
@Inject
EntityManager em;

@Transactional
public void guardarListaSecuencial(List<Venta> lista) {

    int i = 0;

    for (Venta v : lista) {
        v.persist();

        if (++i % 1000 == 0) {
            em.flush();
            em.clear();
        }
    }
}

    @Auditar
    public void guardarListaParalela(List<Venta> lista) {
        int i = 0;

    for (Venta v : lista) {

        try {
            v.persist();

            if (++i % 1000 == 0) {
                System.out.println("Flush en registro " + i);
                em.flush();
                em.clear();
            }

        } catch (Exception e) {
            System.out.println("Error en registro: " + i);
            e.printStackTrace();
            throw e;
        }
    }

    System.out.println("Flush final");
    em.flush();
    em.clear();
}
}