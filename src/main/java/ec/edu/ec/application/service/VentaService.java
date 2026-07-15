package ec.edu.ec.application.service;

import java.util.List;

import ec.edu.ec.domain.model.Reporte;
import ec.edu.ec.domain.model.Venta;
import ec.edu.ec.infraestructure.repository.VentaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.TransactionScoped;

@ApplicationScoped
@TransactionScoped

public class VentaService {
    @Inject
    private VentaRepositoryImpl impl;

    public void crearVenta(Venta venta) {
        this.impl.persist(venta);
    }

    public void actualizar(Venta venta, Integer id) {
        Venta ventaB = Venta.findById(id);
        ventaB.setCliente(venta.getCliente());
        ventaB.setFecha(venta.getFecha());
        ventaB.setTotal(venta.getTotal());
        ventaB.setRuc(venta.getRuc());
    }

    public void actualizar2(Venta venta, Integer id) {
        Venta base = this.impl.findById(id);

    }

    public Venta buscarporId(Integer id) {
        return this.impl.findById(id);
    }

    public void eliminar(Integer id) {
        this.impl.deleteById(id);
    }

    public List<Venta> buscarTodos(){
        return (List<Venta>) this.impl.findAll();
    }
}
