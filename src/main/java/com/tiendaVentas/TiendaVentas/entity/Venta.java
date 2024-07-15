package com.tiendaVentas.TiendaVentas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venta_seq")
    @SequenceGenerator(name = "venta_seq", sequenceName = "ventas_seq", allocationSize = 1)
    @Column(name = "id_ven")
    private Long id_ven;

    @ManyToOne
    @JoinColumn(name = "id_cli")
    private Cliente id_cli;

    @ManyToOne
    @JoinColumn(name = "id_pro")
    private Producto id_pro;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "cantidad")
    private Long cantidad;
}
