package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.aplication.service.FacturaService;
import ec.edu.uce.aplication.service.PedidoService;
import ec.edu.uce.domain.model.Factura;
import ec.edu.uce.domain.model.Pedido;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private PedidoService pedidoService;

        @Override
        public int run(String... args) throws Exception {

            Thread hilo = Thread.currentThread();

            long inicio = System.currentTimeMillis();

            System.out.println("Método principal ejecutado en hilo: " + hilo.getName());

            System.out.println("ID del hilo principal: " + hilo.threadId());

            Pedido pedido = new Pedido();

            pedido.setId(1);

            pedido.setCliente("Juan");

            pedido.setTotal(100);

            pedidoService.guardar(pedido);
            pedidoService.procesarPedido(pedido);

            long fin = System.currentTimeMillis();

            System.out.println("\nTiempo método principal: " + (fin - inicio) + " ms");

            return 0;

        }

    }
}
