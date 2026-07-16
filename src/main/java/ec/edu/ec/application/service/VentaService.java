package ec.edu.ec.application.service;

import java.util.List;

import ec.edu.ec.domain.model.Venta;
import ec.edu.ec.infraestructure.repository.VentaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional

public class VentaService {
    @Inject
    private VentaRepositoryImpl impl;

    public void crearVenta(Venta venta) {
        this.impl.persist(venta);
    }

    public void actualizar(Venta venta, Integer id) {
        System.out.println("Entró al actualizar");
        System.out.println(venta);
        System.out.println(id);

        Venta ventaB = this.impl.findById(id);
        System.out.println(ventaB);

        if (ventaB != null) {
            ventaB.setCliente(venta.getCliente());
            ventaB.setFecha(venta.getFecha());
            ventaB.setRuc(venta.getRuc());
            ventaB.setTotal(venta.getTotal());
        }
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

    public List<Venta> buscarTodos() {
        return this.impl.findAll().list();
    }
}