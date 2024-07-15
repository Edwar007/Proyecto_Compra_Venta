package com.tiendaVentas.TiendaVentas.repository;

import com.tiendaVentas.TiendaVentas.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
