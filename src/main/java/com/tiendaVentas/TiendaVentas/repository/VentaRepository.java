package com.tiendaVentas.TiendaVentas.repository;

import com.tiendaVentas.TiendaVentas.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
