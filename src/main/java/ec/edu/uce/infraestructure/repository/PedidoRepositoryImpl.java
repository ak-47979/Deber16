package ec.edu.uce.infraestructure.repository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import ec.edu.uce.domain.model.Pedido;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
@ApplicationScoped
@Transactional
public class PedidoRepositoryImpl implements PanacheRepositoryBase<Pedido,Integer>{

}