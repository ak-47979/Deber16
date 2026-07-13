package ec.edu.uce.aplication.service;

import java.time.LocalDateTime;
import java.util.Collection;

import ec.edu.uce.domain.model.Auditoria;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Auditar
@Priority(Interceptor.Priority.APPLICATION)
public class AuditarInterceptor {
 
    @Inject
    
    private AuditoriaService auditoriaService;
 
    @AroundInvoke
    public Object medirTiempoYAuditar(InvocationContext context) throws Exception {
 
        long inicio = System.currentTimeMillis();

        try {
            return context.proceed();
        } finally {

            long fin = System.currentTimeMillis();
            long tiempo = fin - inicio;

            String nombreMetodo = context.getMethod().getDeclaringClass().getSimpleName()
                    + "." + context.getMethod().getName();

            System.out.println("------AUDITORIA--------------");
            System.out.println("Método: " + nombreMetodo);

            Object[] parametros = context.getParameters();

            for (Object parametro : parametros) {

                if (parametro instanceof Collection<?>) {

                    for (Object elemento : (Collection<?>) parametro) {

                        System.out.println("Argumento: " + elemento);

                        Auditoria auditoria = new Auditoria();
                        auditoria.setNombreMetodo(nombreMetodo);
                        auditoria.setArgumentos(elemento.toString());
                        auditoria.setFechaHoraEjecucion(LocalDateTime.now());
                        auditoria.setTiempoEjecucionMs(tiempo);

                        auditoriaService.guardar(auditoria);
                    }

                } else {

                    System.out.println("Argumento: " + parametro);

                    Auditoria auditoria = new Auditoria();
                    auditoria.setNombreMetodo(nombreMetodo);
                    auditoria.setArgumentos(parametro != null ? parametro.toString() : "null");
                    auditoria.setFechaHoraEjecucion(LocalDateTime.now());
                    auditoria.setTiempoEjecucionMs(tiempo);

                    auditoriaService.guardar(auditoria);
                }
            }

            System.out.println("Tiempo de ejecución: " + tiempo + " s");
            System.out.println("================================");
        }
    }
}
