package ec.edu.uce.aplication.service;

import ec.edu.uce.domain.model.Cuenta;
import ec.edu.uce.domain.repository.CuentaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CuentaService {
    @Inject
    private CuentaRepository cuentaRepository;
    public void crear(Cuenta cuenta) {
       this.cuentaRepository.crear(cuenta);
    }
    public Cuenta findId(Integer id) {
        return this.cuentaRepository.findId(id);
    }
        
}
