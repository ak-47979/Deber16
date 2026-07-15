package ec.edu.ec.infraestructure.repository;

import ec.edu.ec.domain.model.Venta;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class VentaRepositoryImpl implements PanacheRepositoryBase<Venta,Integer>{

}
