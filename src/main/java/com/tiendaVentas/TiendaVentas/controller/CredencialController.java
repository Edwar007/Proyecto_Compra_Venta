package com.tiendaVentas.TiendaVentas.controller;

import com.tiendaVentas.TiendaVentas.dto.CredencialDTO;
import com.tiendaVentas.TiendaVentas.entity.LoginForm;
import com.tiendaVentas.TiendaVentas.service.CredencialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credencial")
public class CredencialController {
    @Autowired
    CredencialService credencialService;

    @PostMapping("/login")
    public ResponseEntity<CredencialDTO> login(@RequestBody LoginForm loginForm) {
        String correo = loginForm.getCorreo();
        String clave = loginForm.getClave();
        System.out.println(correo+" "+clave);
        return credencialService.crearVenta(correo, clave);
    }
}
