package com.tiendaVentas.TiendaVentas.service.impl;

import com.tiendaVentas.TiendaVentas.dto.VentaDTO;
import com.tiendaVentas.TiendaVentas.entity.Cliente;
import com.tiendaVentas.TiendaVentas.entity.Producto;
import com.tiendaVentas.TiendaVentas.entity.Venta;
import com.tiendaVentas.TiendaVentas.repository.ClienteRepository;
import com.tiendaVentas.TiendaVentas.repository.ProductoRepository;
import com.tiendaVentas.TiendaVentas.repository.VentaRepository;
import com.tiendaVentas.TiendaVentas.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public VentaDTO crearVenta(VentaDTO ventaDTO) {
        Cliente cliente = clienteRepository.findById(ventaDTO.getId_cli())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Producto producto = productoRepository.findById(ventaDTO.getId_pro())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Venta venta = Venta.builder()
                .id_cli(cliente)
                .id_pro(producto)
                .fecha(ventaDTO.getFecha())
                .cantidad(ventaDTO.getCantidad())
                .build();

        Venta savedVenta = ventaRepository.save(venta);

        return VentaDTO.builder()
                .id_ven(savedVenta.getId_ven())
                .id_cli(savedVenta.getId_cli().getId_cli())
                .id_pro(savedVenta.getId_pro().getId_pro())
                .fecha(savedVenta.getFecha())
                .cantidad(savedVenta.getCantidad())
                .build();
    }
}
