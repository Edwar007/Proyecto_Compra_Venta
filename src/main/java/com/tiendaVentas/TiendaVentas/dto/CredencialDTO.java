package com.tiendaVentas.TiendaVentas.dto;

import com.tiendaVentas.TiendaVentas.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CredencialDTO {

    private Long idCre;
    private String correo;
    private String clave;
    private Long rol;
    private Cliente cliente;
}
