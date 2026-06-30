package ec.edu.uce.aplication.service;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class MedirTiempoInterceptor {

    @AroundInvoke
     public Object medir(InvocationContext context) throws Exception {

        String nombreMetodo = context.getMethod().getName();

        long inicio = System.currentTimeMillis();
        System.out.println("Iniciando método: " + nombreMetodo);

        Object resultado = context.proceed();

        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;

        System.out.println("Tiempo de ejecución: " + nombreMetodo + " tiempo: " + tiempo + " ms");

        return resultado;
    }
}