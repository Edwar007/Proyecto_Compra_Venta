package com.tiendaVentas.TiendaVentas.repository;

import com.tiendaVentas.TiendaVentas.entity.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredencialRepository extends JpaRepository<Credencial, Long> {
    Optional<Credencial> findByCorreoAndClave(String correo, String clave);
}
