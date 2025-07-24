package uce.edu.web.api.service.to;

import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.controller.ProductoController;

public class ProductoDetalleTo {
    Integer codigoBarra;
    String nombre;
    Double precio;
    Map <String,String> liks = new HashMap<>();

    public Integer getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(Integer codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Map<String, String> getLiks() {
        return liks;
    }

    public void setLiks(Map<String, String> liks) {
        this.liks = liks;
    }

    public void uriBuild(UriInfo uriInfo){
        if(this.getCodigoBarra() != null){
            this.getLiks().put("producto", uriInfo.getBaseUriBuilder()
            .path(ProductoController.class)
            .path(String.valueOf(this.getCodigoBarra()))
            .build().toString()
            );
        }

    }
  
}
