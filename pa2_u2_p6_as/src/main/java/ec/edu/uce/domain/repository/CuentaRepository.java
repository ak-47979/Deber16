package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Cuenta;

public interface  CuentaRepository {
    public void crear(Cuenta cuenta);
    public Cuenta findId(Integer id);

}
