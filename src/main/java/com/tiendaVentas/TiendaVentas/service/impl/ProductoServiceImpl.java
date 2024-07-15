package com.tiendaVentas.TiendaVentas.service.impl;

import com.tiendaVentas.TiendaVentas.dto.ProductoDTO;
import com.tiendaVentas.TiendaVentas.entity.Producto;
import com.tiendaVentas.TiendaVentas.repository.ProductoRepository;
import com.tiendaVentas.TiendaVentas.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    @Override
    public List<ProductoDTO> listarProductos() {
        List<ProductoDTO> lProductoDTO = new ArrayList<>();
        List<Producto> listProductos = productoRepository.findByActivoTrue();
        for(Producto producto : listProductos){
        lProductoDTO.add(ProductoDTO.builder()
            .id(producto.getId_pro())
            .titulo(producto.getNombre())
            .precio(producto.getPrecio())
            .stock(producto.getStock())
            .imagen(producto.getUrl())
            .build());
        }

        return lProductoDTO;
    }
    @Override
    public ProductoDTO crearProducto(ProductoDTO producto) {
        Producto produc =Producto.builder()
                .id_pro(producto.getId())
                .nombre(producto.getTitulo())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .url(producto.getImagen())
                .build();
        productoRepository.save(produc);
        return producto;
    }
    @Override
    public ResponseEntity<Void> eliminarProducto(String id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            Producto productoExistente = producto.get();
            productoExistente.setActivo(false);
            productoRepository.save(productoExistente);
            return ResponseEntity.noContent().build();  // 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }
    @Override
    public ResponseEntity<Void> actualizarProducto(ProductoDTO producto) {
        Optional<Producto> prod = productoRepository.findById(producto.getId());
        prod.get().setId_pro(producto.getId());
        prod.get().setNombre(producto.getTitulo());
        prod.get().setPrecio(producto.getPrecio());
        prod.get().setStock(producto.getStock());
        prod.get().setUrl(producto.getImagen());
        productoRepository.save(prod.get());
        return ResponseEntity.noContent().build();
    }
}
