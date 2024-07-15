package com.tiendaVentas.TiendaVentas.dto;

import com.tiendaVentas.TiendaVentas.entity.Cliente;
import com.tiendaVentas.TiendaVentas.entity.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {
    private Long id_ven;
    private Long id_cli;
    private String id_pro;
    private Date fecha;
    private Long cantidad;
}