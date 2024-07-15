package com.tiendaVentas.TiendaVentas.dto;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private String id;
    private String titulo;
    private Double precio;
    private Long stock;
    private String imagen;
    private Boolean activo;
}
