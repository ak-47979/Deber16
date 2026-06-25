package ec.edu.uce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.aplication.service.CuentaService;
import ec.edu.uce.aplication.service.TransferenciaService;
import ec.edu.uce.domain.model.Cuenta;
import ec.edu.uce.domain.model.Transferencia;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@QuarkusMain
public class Main {
public static void main(String[] args) {
    Quarkus.run(App.class,args );
}
public static class App implements  QuarkusApplication{
    @Inject
    private TransferenciaService transferenciaService;

    @Inject
    private CuentaService cuentaService;
    @Override
    @Transactional
    public int run(String... args) throws Exception {
        System.out.println("Conectado a la base");
        Cuenta cOrigen = new Cuenta();
        cOrigen.setNombre("Andy Suquilandi");
        cOrigen.setSaldo(new BigDecimal(2000));
        

        Cuenta cDestino = new Cuenta();
        cDestino.setNombre("Jhon Cordova");
        cDestino.setSaldo(new BigDecimal(100));
        cuentaService.crear(cOrigen);
        cuentaService.crear(cDestino);

        System.out.println("CUENTAS ANTES DE TRANSFERENCIA ");
        System.out.println( cOrigen.toString());
        System.out.println(cDestino.toString());

        BigDecimal montoTrans=new BigDecimal(200);
       
        

        transferenciaService.realizar(cOrigen.getId(), cDestino.getId(), montoTrans);


         System.out.println("CUENTAS DESPUES DE TRANSFERENCIA ");
         System.out.println( cuentaService.findId(1));
         System.out.println( cuentaService.findId(2));
        

        Cuenta c1 = cuentaService.findId(1);
        Cuenta c2 = cuentaService.findId(2);
        c1.getTransferenciasEnviadas();
        c1.getTransferenciasRecibidas();


        List<Transferencia>t1 = c2.getTransferenciasEnviadas();
        List<Transferencia>t2 = c2.getTransferenciasEnviadas();
        c2.getTransferenciasRecibidas();
        System.out.println(c2.getTransferenciasEnviadas());
        List<Cuenta> cuenta = new ArrayList<>();
        for (Object elem : cuenta) {
            System.out.println(elem.toString());
        }
        
        System.out.println("Fechas de transferencia1");
        for (Object elem : t1) {

            System.out.println("Fecha: "+elem.toString());
        }
          System.out.println("Fechas de transferencia2");
         for (Object elem : t2) {
            System.out.println("Fecha: "+elem.toString());
        }

       
        return 0;
    }

}

}
