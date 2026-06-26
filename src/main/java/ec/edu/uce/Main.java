package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.aplication.service.FacturaService;
import ec.edu.uce.aplication.service.MailService;
import ec.edu.uce.aplication.service.ReporteService;
import ec.edu.uce.domain.model.Factura;
import ec.edu.uce.domain.model.Mail;
import ec.edu.uce.domain.model.Reporte;
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
        private FacturaService facturaService;
        @Inject
        private ReporteService reporteService;

        @Inject
        private MailService mailService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Creando Factura");
            Factura factura = new Factura();
            factura.setFecha(LocalDate.now());
            factura.setNumero("0001-0004");
            factura.setRuc("1753021564321564");

            facturaService.guardar(factura);
            Factura fac = facturaService.buscarId(1);
            System.out.println(fac.toString());

            System.out.println("Creando Mail");

            Mail mail = new Mail();
            mail.setRemitente("Andy");
            mail.setDestinatario("Alex");
            mail.setAsunto("Consulta de auto");
            mail.setMensaje("solicito precio de los autos");
            mail.setFecha(LocalDate.now());

            mailService.guardar(mail);
            Mail mailId = mailService.buscarId(1);
            System.out.println(mailId.toString());
            System.out.println("Creando Reporte");

            Reporte reporte = new Reporte();

            reporte.setAutor("Alex");
            reporte.setDescripcion("Autos vendidos: 2");
            reporte.setTitulo("Numero de autos vendidos");
            reporte.setFecha(LocalDate.now());

            reporteService.guardar(reporte);

            Reporte reporteId = reporteService.buscarId(1);
            System.out.println(reporteId.toString());
            return 0;

        }

    }
}
