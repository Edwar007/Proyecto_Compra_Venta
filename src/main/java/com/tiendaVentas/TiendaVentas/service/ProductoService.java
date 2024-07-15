package com.tiendaVentas.TiendaVentas.service;

import com.tiendaVentas.TiendaVentas.dto.ProductoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface ProductoService {
    List<ProductoDTO> listarProductos();
    ProductoDTO crearProducto(ProductoDTO producto);
    ResponseEntity<Void> eliminarProducto(String id);
    ResponseEntity<Void> actualizarProducto(ProductoDTO producto);
}
