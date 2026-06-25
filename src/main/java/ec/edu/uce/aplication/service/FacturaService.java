package ec.edu.uce.aplication.service;

import ec.edu.uce.domain.model.Factura;
import ec.edu.uce.infraestructure.repository.FacturaRespositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class FacturaService {

    @Inject
    private FacturaRespositoryImpl facturaRespositoryImpl;
    public void guardar(Factura factura){
        this.facturaRespositoryImpl.persist(factura);
    }
    public Factura buscarId(Integer id){
       // return this.facturaRespositoryImpl.findById(id);
        return Factura.findById(id);
    }
}
