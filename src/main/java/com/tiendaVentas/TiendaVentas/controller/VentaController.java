package com.tiendaVentas.TiendaVentas.controller;

import com.tiendaVentas.TiendaVentas.dto.VentaDTO;
import com.tiendaVentas.TiendaVentas.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    VentaService ventaService;
    @PostMapping("/crear-venta")
    public VentaDTO crearProducto(@RequestBody VentaDTO venta){
        return ventaService.crearVenta(venta);
    }
}
