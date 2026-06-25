package ec.edu.uce.infraestructure.repository;

import ec.edu.uce.domain.model.Factura;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class FacturaRespositoryImpl implements PanacheRepositoryBase<Factura, Integer> {
    public  Factura busarporGenero(String genero){
        return  null;
    }
}
