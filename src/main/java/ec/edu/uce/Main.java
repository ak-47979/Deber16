package ec.edu.uce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.aplication.service.FacturaServiceCompletableFuture;
import ec.edu.uce.aplication.service.FacturaServiceParalelo;
import ec.edu.uce.aplication.service.ReporteService;
import ec.edu.uce.domain.model.Factura;
import ec.edu.uce.domain.model.Reporte;
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
        private ReporteService reporteService;
        @Inject
        private FacturaServiceParalelo facturaServiceParalelo;

        @Inject
        private FacturaServiceCompletableFuture facturaServiceCompletableFuture;
    @Override
    public int run(String... args) throws Exception {
        
        String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre el hilo ReporteService" + nombrehilo);
        System.out.println("ID:" + Thread.currentThread().threadId());

        
        Factura factura = new Factura();
        factura.setFecha(LocalDate.now());
        factura.setNumero("0001-0004");
        factura.setRuc("1753021564321564");
        List<Reporte> lista = new ArrayList<>();
        for(int i=0; i<100000 ; i++){
     Reporte re = new Reporte();
     re.setTitulo("repo1");
     re.setAutor("autor1");
     re.setFecha(LocalDate.now());
     lista.add(re);
}     
     // this.reporteService.guardarLis(lista);
          System.out.println("Segundo metodo");
      this.reporteService.guardarLisParalelo(lista);
     
       
        return 0;

       
   }

}
}
