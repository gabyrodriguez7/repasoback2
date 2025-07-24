package uce.edu.web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.model.Producto;

@ApplicationScoped
@Transactional
public class ProductoRepoImpl implements IProductoRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Producto producto) {
        entityManager.persist(producto);
    }

    @Override
    public List<Producto> obtenerTodos() {
        TypedQuery myQuery = entityManager.createQuery("SELECT p FROM Producto p",Producto.class);
        return myQuery.getResultList();
    }

    @Override
    public Producto obtenerPorcodigoBarra(Integer codigoBarra) {
      return entityManager.find(Producto.class, codigoBarra);
    }

    @Override
    public void actualizar(Producto producto) {
        entityManager.merge(producto);
    }

    @Override
    public void eliminarPorCodigoBarra(Integer codigoBarra) {
        entityManager.remove(this.obtenerPorcodigoBarra(codigoBarra));
    }



    
}
