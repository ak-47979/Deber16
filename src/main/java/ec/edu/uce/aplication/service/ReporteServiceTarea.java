package ec.edu.uce.aplication.service;

import ec.edu.uce.domain.model.Reporte;

public class ReporteServiceTarea implements Runnable {

    private Reporte reporte;

    
    private ReporteService reporteService;
    public ReporteServiceTarea(Reporte reporte,ReporteService reporteService ) {
        this.reporte = reporte;
        this.reporteService = reporteService;
    }
public ReporteServiceTarea(){

}

    @Override
    public void run() {
        System.out.println(this.reporteService);
        this.reporteService.guardar(this.reporte);
    }

    

}
