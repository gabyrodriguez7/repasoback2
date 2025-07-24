package uce.edu.web.api.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="prod_codigoBarra")
    Integer codigoBarra;

    @Column(name="prod_nombre")
    String nombre;
    @Column(name="prod_precio")
    Double precio;
    @Column(name="prod_stock")
    Integer stock;
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
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    
}
