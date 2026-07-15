package ec.edu.ec.application.service;

import ec.edu.ec.domain.model.Reporte;
import ec.edu.ec.infraestructure.repository.ReporteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl ri;

    public void crearReporte(Reporte reporte) {

        this.ri.persist(reporte);
    }

    public void actualizarReporte(Reporte reporte, Integer id) {

        // this.ri.getEntityManager().merge(reporte);

        Reporte base = this.buscaReporteId(id);
        base.setFormato(reporte.getFormato());
        base.setDescripcion(reporte.getDescripcion());
        base.setFecha(reporte.getFecha());
        base.setTitulo(reporte.getTitulo());

        // no hace falta realizar explicitamente un update

    }

    public void actualizarReporte2(Reporte reporte) {

        Reporte base = this.buscaReporteId(reporte.getId());

    }

    public Reporte buscaReporteId(Integer id) {

        return Reporte.findById(id);
    }

    public void eliminarReporteId(Integer id) {

        this.ri.deleteById(id);
    }

}
