package com.tiendaVentas.TiendaVentas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id_cli;
    private String nombre;
    private String apellidos;
    private String cedula;
    private String telefono;
    private String direccion;
}
