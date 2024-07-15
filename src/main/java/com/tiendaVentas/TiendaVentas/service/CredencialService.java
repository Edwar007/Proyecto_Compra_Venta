package com.tiendaVentas.TiendaVentas.service;

import com.tiendaVentas.TiendaVentas.dto.CredencialDTO;
import org.springframework.http.ResponseEntity;

public interface CredencialService {
    ResponseEntity<CredencialDTO> crearVenta(String correo, String clave);
}
