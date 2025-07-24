package uce.edu.web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IProductoRepo;
import uce.edu.web.api.repository.model.Producto;

@ApplicationScoped
public class ProductoServiceImpl implements IProductoService{
    @Inject
    IProductoRepo productoRepo;

    @Override
    public void insertar(Producto producto) {
      this.productoRepo.insertar(producto);
    }

    @Override
    public List<Producto> obtenerTodos() {
        return this.productoRepo.obtenerTodos();
    }

    @Override
    public Producto obtenerPorcodigoBarra(Integer codigoBarra) {
        return this.productoRepo.obtenerPorcodigoBarra(codigoBarra);
    }

    @Override
    public void actualizar(Producto producto) {
        this.productoRepo.actualizar(producto);
    }

    @Override
    public void eliminarPorCodigoBarra(Integer codigoBarra) {
        this.productoRepo.eliminarPorCodigoBarra(codigoBarra);
    }


 
}