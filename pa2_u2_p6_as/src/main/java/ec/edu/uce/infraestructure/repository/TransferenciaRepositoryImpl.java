package ec.edu.uce.infraestructure.repository;

import java.math.BigDecimal;

import ec.edu.uce.domain.model.Cuenta;
import ec.edu.uce.domain.model.Transferencia;
import ec.edu.uce.domain.repository.TransferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Transactional
@ApplicationScoped
public class TransferenciaRepositoryImpl implements TransferenciaRepository {
    @Inject
    private EntityManager em; 
    @Override
    public void crear(Transferencia transferencia) {
        this.em.persist(transferencia);
    }

    @Override
    public void realizar(Integer idOrigen, Integer idDestino, BigDecimal monto) {
        Cuenta origen=this.em.find(Cuenta.class, idOrigen);
        Cuenta destino=this.em.find(Cuenta.class, idDestino);
         
    origen.setSaldo(origen.getSaldo().subtract(monto));
    destino.setSaldo(destino.getSaldo().add(monto));
    em.merge(origen);
    em.merge(destino);
    }


}
