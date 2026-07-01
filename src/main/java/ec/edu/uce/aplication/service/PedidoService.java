package ec.edu.uce.aplication.service;

import ec.edu.uce.domain.model.Pedido;
import ec.edu.uce.infraestructure.repository.PedidoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class PedidoService {
    @Inject 
    private PedidoRepositoryImpl pedidoRepositoryImpl;
    public void guardar(Pedido pedido){
        this.pedidoRepositoryImpl.persist(pedido);
    }
    public void buscarId(Integer id){
        this.pedidoRepositoryImpl.findById(id);
    }
    @MedirTiempo
    public void procesarPedido(Pedido pedido) {

        mostrarHilo("procesarPedido");

        validarCliente();

        calcularDescuento();

        generarFactura();

        enviarCorreo();

    }

    @MedirTiempo
    public void validarCliente() {

        mostrarHilo("validarCliente");

        try {
            Thread.sleep(200);
        } catch (Exception e) {
        }

        System.out.println("Validando cliente del pedido");

    }

    @MedirTiempo
    public void calcularDescuento() {

        mostrarHilo("calcularDescuento");

        try {
            Thread.sleep(300);
        } catch (Exception e) {
        }

        System.out.println("Calculando descuento");

    }

    @MedirTiempo
    public void generarFactura() {

        mostrarHilo("generarFactura");

        try {
            Thread.sleep(150);
        } catch (Exception e) {
        }

        System.out.println("Generando factura");

    }

    @MedirTiempo
    public void enviarCorreo() {

        mostrarHilo("enviarCorreo");

        try {
            Thread.sleep(250);
        } catch (Exception e) {
        }

        System.out.println("Enviando correo al cliente");

    }

    private void mostrarHilo(String metodo) {

        Thread hilo = Thread.currentThread();

        System.out.println("\nMétodo ejecutado: " + metodo);

        System.out.println("Nombre del hilo: " + hilo.getName());

        System.out.println("ID del hilo: " + hilo.threadId());

    }

}