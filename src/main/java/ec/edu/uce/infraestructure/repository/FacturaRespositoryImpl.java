package ec.edu.uce.infraestructure.repository;

import java.time.LocalDate;

import ec.edu.uce.aplication.service.MailService;
import ec.edu.uce.aplication.service.ReporteService;
import ec.edu.uce.domain.model.Factura;
import ec.edu.uce.domain.model.Mail;
import ec.edu.uce.domain.model.Reporte;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class FacturaRespositoryImpl implements PanacheRepositoryBase<Factura, Integer> {
    public  Factura busarporGenero(String genero){
        return  null;
    }
    

}
