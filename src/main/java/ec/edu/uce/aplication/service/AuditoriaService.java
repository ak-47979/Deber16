package ec.edu.uce.aplication.service;


import ec.edu.uce.domain.model.Auditoria;
import ec.edu.uce.domain.repository.AuditoriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AuditoriaService {

    @Inject
    private AuditoriaRepository repository;

    public void guardar(Auditoria auditoria){
        this.repository.insertar(auditoria);
    }

}
