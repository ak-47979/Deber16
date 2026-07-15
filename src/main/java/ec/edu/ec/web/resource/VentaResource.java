package ec.edu.ec.web.resource;


import ec.edu.ec.application.service.VentaService;
import ec.edu.ec.domain.model.Venta;
import jakarta.inject.Inject;

public class VentaResource {
    @Inject
    private VentaService ventaService;
    public Venta buscarporId(Integer Id){
        return this.ventaService.buscarporId(Id);
    }
}
