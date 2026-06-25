package ec.edu.uce.infraestructure.repository;

import ec.edu.uce.domain.model.Cuenta;
import ec.edu.uce.domain.repository.CuentaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuentaRepositoryImpl implements CuentaRepository{
    @Inject
    private EntityManager em;
    @Override
    public void crear(Cuenta cuenta) {
       this.em.persist(cuenta);
    }
    @Override
    public Cuenta findId(Integer id) {
       return this.em.find(Cuenta.class, id);
    }

   
}
