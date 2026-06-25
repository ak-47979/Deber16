package ec.edu.uce.aplication.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import ec.edu.uce.domain.model.Cuenta;
import ec.edu.uce.domain.model.Transferencia;
import ec.edu.uce.domain.repository.CuentaRepository;
import ec.edu.uce.domain.repository.TransferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TransferenciaService {
    @Inject
    private TransferenciaRepository transferenciaRepository;
    @Inject
    private CuentaRepository cuentaRepository;
     public void crear(Transferencia transferencia){
        this.transferenciaRepository.crear(transferencia);
     }
  public void realizar(Integer idOrigen, Integer idDestino, BigDecimal monto) {

    Cuenta cOrigen = cuentaRepository.findId(idOrigen);
    Cuenta cDestino = cuentaRepository.findId(idDestino);
 if (cOrigen == null || cDestino == null) {
        throw new RuntimeException("Cuenta no encontrada");
    }

     if (monto.compareTo(BigDecimal.ZERO) <= 0) {
        throw new RuntimeException("El monto debe ser mayor que cero");
    }

    if (cOrigen.getSaldo().compareTo(monto) < 0) {
        throw new RuntimeException("Saldo insuficiente");
    }
    Transferencia transferencia = new Transferencia();
    transferencia.setCuentaOrigen(cOrigen);
    transferencia.setCuentaDestino(cDestino);
    transferencia.setMonto(monto);
    transferencia.setFecha(LocalDate.now());

    transferenciaRepository.crear(transferencia);

    transferenciaRepository.realizar(idOrigen, idDestino, monto);
}
}
