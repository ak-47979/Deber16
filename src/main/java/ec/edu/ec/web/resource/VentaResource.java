package ec.edu.ec.web.resource;

import java.util.List;

import ec.edu.ec.application.service.VentaService;
import ec.edu.ec.domain.model.Venta;
import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@Path("/venta")
public class VentaResource {
    @Inject
    private VentaService ventaService;
    //http://localhost:8081/venta/todos
    @Path("/todos")
    @GET
    public List<Venta> buscarTodos(){
        return this.ventaService.buscarTodos();
    }

    //http://localhost:8081/venta/crear
    @Path("/crear")
    @POST
    public void crear(Venta venta){
         this.ventaService.crearVenta(venta);
    }

    //http://localhost:8081/venta/buscar/{id}
    @Path("/buscar/{id}")
    @GET
    public Venta buscarporId(@PathParam("id")Integer Id){
        return this.ventaService.buscarporId(Id);
    }

    //Link http://localhost:8081/venta/actualizar
    @Path("/actualizar/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void actualizar( Venta venta,@PathParam("id")Integer Id){
         this.ventaService.actualizar(venta, Id);
    }
}
