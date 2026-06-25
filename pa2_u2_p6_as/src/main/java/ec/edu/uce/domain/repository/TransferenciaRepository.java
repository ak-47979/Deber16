package ec.edu.uce.domain.repository;

import java.math.BigDecimal;

import ec.edu.uce.domain.model.Transferencia;

public interface  TransferenciaRepository {
    public void crear(Transferencia transferencia);
    public void realizar(Integer idOrigen, Integer idDestino, BigDecimal monto);
}
