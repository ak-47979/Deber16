package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.aplication.service.FacturaServiceCompletableFuture;
import ec.edu.uce.aplication.service.FacturaServiceParalelo;
import ec.edu.uce.aplication.service.ReporteService;
import ec.edu.uce.aplication.service.VentaService;
import ec.edu.uce.domain.model.Factura;
import ec.edu.uce.domain.model.Reporte;
import ec.edu.uce.domain.model.Venta;
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
        private ReporteService reporteService;

        @Inject
        private VentaService ventaService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Insertando 500 000 de ventas...");
            List<Venta> lista = new ArrayList<>();

            for (int i = 1; i <= 500000; i++) {
                
                Venta venta = new Venta();
                venta.setCliente("Andy");
                venta.setFecha(LocalDate.now());
                venta.setTotal(BigDecimal.valueOf(200));
                lista.add(venta);

            }
            long inicio = System.currentTimeMillis();

            System.out.println("Antes de guardar");
            ventaService.guardarListaSecuencial(lista);
            //ventaService.guardarListaParalela(lista);

            System.out.println("Después de guardar");

            long fin = System.currentTimeMillis();

            System.out.println("Tiempo: " + (fin - inicio) + " ms");

            return 0;

        }

    }
}
