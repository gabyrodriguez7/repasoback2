package uce.edu.web.api.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.service.IProductoService;
import uce.edu.web.api.service.mapper.ProductoMapper;
import uce.edu.web.api.service.to.ProductoDetalleTo;
import uce.edu.web.api.service.to.ProductoTo;

@Path("/productos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductoController {
    @Inject
    IProductoService productoService;

    @Context
    UriInfo uriInfo;

    @GET
    @Path("")
    @Operation(
        summary = "obtenertodos",
        description = "capacidad para obtener todos"
    )
    public Response obtenerTodos(){
        List<ProductoTo> prod = this.productoService.obtenerTodos().stream().map(ProductoMapper::toTo).collect(Collectors.toList());
        return Response.status(Response.Status.OK).entity(prod).build();
    }


    @POST
    @Path("")
    @Operation(
        summary = "creartodos",
        description = "capacidad para crear todos"
    )
    public Response crearProductos(@RequestBody ProductoTo productoTo){
        this.productoService.insertar(ProductoMapper.toEntity(productoTo));
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/{codigoBarra}")
    @Operation(
        summary = "obtener todos por codigo de barras ",
        description = "capacidad para obtener todos"
    )
    public Response obtenerPorCodigoBarra(@PathParam("codigoBarra") Integer codigoBarra){
        ProductoTo productoTo = ProductoMapper.toTo(this.productoService.obtenerPorcodigoBarra(codigoBarra));
        return Response.status(Response.Status.OK).entity(productoTo).build();
    }

    @PUT
    @Path("/{codigoBarra}")
    @Operation(
        summary = "actualizar todos",
        description = "capacidad para actualizar todos"
    )
    public Response actualizarPorCodigoBarra(@RequestBody ProductoTo productoTo, @PathParam("codigoBarra") Integer codigoBarra){
        productoTo.setCodigoBarra(codigoBarra);
        this.productoService.actualizar(ProductoMapper.toEntity(productoTo));
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{codigoBarra}")
    @Operation(
        summary = "eliminar todos",
        description = "capacidad para eliminar todos"
    )
    public Response eliminarPorCodigoBarra(@PathParam("codigoBarra") Integer codigoBarra){
        this.productoService.eliminarPorCodigoBarra(codigoBarra);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/producto")
    @Operation(
        summary = "obtener detalles",
        description = "capacidad para obtener detalles"
    )
    public Response obtenerDetalle(){
        List<ProductoDetalleTo> productosResumenTo = this.productoService.obtenerTodos().stream().map(ProductoMapper::toDetalleTo).peek(productos->{
           productos.uriBuild(uriInfo); 
        }).collect(Collectors.toList());
        return Response.status(Response.Status.OK).entity(productosResumenTo).build();
    }


}
