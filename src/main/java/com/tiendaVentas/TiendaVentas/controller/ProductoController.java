package com.tiendaVentas.TiendaVentas.controller;

import com.tiendaVentas.TiendaVentas.dto.ProductoDTO;
import com.tiendaVentas.TiendaVentas.service.ProductoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/listar-productos")
    public ResponseEntity<List<ProductoDTO>> listarProductos(){
        return new ResponseEntity<>(productoService.listarProductos(), null, HttpStatus.OK);
    }
    @PostMapping("/crear-producto")
    public ProductoDTO crearProducto(@RequestBody ProductoDTO producto){
        return productoService.crearProducto(producto);
    }
    @DeleteMapping("/eliminar-producto/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id") String id) {
        return productoService.eliminarProducto(id);
    }
    @PutMapping("/actualizar-producto")
    public ResponseEntity<Void> actualizarPersona(@RequestBody ProductoDTO producto) {
        System.out.println(producto);
        return productoService.actualizarProducto(producto);
    }


}
