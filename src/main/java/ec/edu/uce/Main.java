package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.aplication.service.FacturaService;
import ec.edu.uce.domain.model.Factura;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
@QuarkusMain
public class Main {
   public static void main(String[] args) {
        Quarkus.run(App.class,args);
   }
   public static class App implements QuarkusApplication{
    @Inject
        private FacturaService facturaService;
    @Override
    public int run(String... args) throws Exception {
        
        String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre el hilo ReporteService" + nombrehilo);
        System.out.println("ID:" + Thread.currentThread().threadId());

        
       Factura factura = new Factura();
        factura.setFecha(LocalDate.now());
        factura.setNumero("0001-0004");
        factura.setRuc("1753021564321564");

        facturaService.guardarF(factura);
        Factura fac =facturaService.buscarId(1);
        System.out.println(fac.toString());
        return 0;

        //en el metodo guardarR y guardar mail ponga un medidor de tiempo con interceptor
       
   }

}
}
