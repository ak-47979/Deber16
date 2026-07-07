package ec.edu.uce.aplication.service;

import ec.edu.uce.domain.model.Reporte;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Dependent
public class ReporteServiceTarea implements Runnable {

    private Reporte reporte;

    
    @Inject
    private ReporteService reporteService;



public ReporteServiceTarea(){

}

    @Override
    public void run() {
        System.out.println(this.reporteService);
        this.reporteService.guardar(this.reporte);
    }


    public Reporte getReporte() {
        return reporte;
    }

    public ReporteService getReporteService() {
        return reporteService;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public void setReporteService(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

 
    

}
