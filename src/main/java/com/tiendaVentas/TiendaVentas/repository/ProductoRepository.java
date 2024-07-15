package com.tiendaVentas.TiendaVentas.repository;

import com.tiendaVentas.TiendaVentas.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, String>{
    List<Producto> findByActivoTrue();
}
