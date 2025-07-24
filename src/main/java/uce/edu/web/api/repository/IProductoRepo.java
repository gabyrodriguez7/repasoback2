package uce.edu.web.api.repository;

import java.util.List;

import uce.edu.web.api.repository.model.Producto;

public interface IProductoRepo {

    public void insertar(Producto producto);
    public List<Producto> obtenerTodos();
    public Producto obtenerPorcodigoBarra(Integer codigoBarra);
    public void actualizar(Producto producto);
    public void eliminarPorCodigoBarra(Integer codigoBarra);

    
}
