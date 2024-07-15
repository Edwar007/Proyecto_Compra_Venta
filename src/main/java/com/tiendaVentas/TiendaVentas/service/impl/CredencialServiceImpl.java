package com.tiendaVentas.TiendaVentas.service.impl;

import com.tiendaVentas.TiendaVentas.dto.CredencialDTO;
import com.tiendaVentas.TiendaVentas.entity.Credencial;
import com.tiendaVentas.TiendaVentas.repository.CredencialRepository;
import com.tiendaVentas.TiendaVentas.service.CredencialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CredencialServiceImpl implements CredencialService {
    @Autowired
    CredencialRepository credencialRepository;
    @Override
    public ResponseEntity<CredencialDTO> crearVenta(String correo, String clave) {

        Optional<Credencial> credencial = credencialRepository.findByCorreoAndClave(correo, clave);
        if (credencial.isPresent()) {
            CredencialDTO credencialDTO = CredencialDTO.builder()
                .idCre(credencial.get().getIdCre())
                .correo(credencial.get().getCorreo())
                .clave(credencial.get().getClave())
                .rol(credencial.get().getRol())
                .cliente(credencial.get().getCliente())
                .build();
            return ResponseEntity.ok(credencialDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
