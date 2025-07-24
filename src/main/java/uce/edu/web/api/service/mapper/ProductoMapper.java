package uce.edu.web.api.service.mapper;

import uce.edu.web.api.repository.model.Producto;
import uce.edu.web.api.service.to.ProductoDetalleTo;
import uce.edu.web.api.service.to.ProductoTo;

public class ProductoMapper {

    public static Producto toEntity(ProductoTo productoTo){
        Producto prod = new Producto();
        prod.setCodigoBarra(productoTo.getCodigoBarra());
        prod.setNombre(productoTo.getNombre());
        prod.setPrecio(productoTo.getPrecio());
        prod.setStock(productoTo.getStock());
        return prod;
    }

    public static ProductoTo toTo(Producto producto){
        ProductoTo prodTo = new ProductoTo();
        prodTo.setCodigoBarra(producto.getCodigoBarra());
        prodTo.setNombre(producto.getNombre());
        prodTo.setPrecio(producto.getPrecio());
        prodTo.setStock(producto.getStock());
        return prodTo;
    }

    public static ProductoDetalleTo toDetalleTo(Producto producto){
        ProductoDetalleTo prod = new ProductoDetalleTo();
        prod.setCodigoBarra(producto.getCodigoBarra());
        prod.setNombre(producto.getNombre());
        prod.setPrecio(producto.getPrecio());
        return prod;
    }

    
    
}
