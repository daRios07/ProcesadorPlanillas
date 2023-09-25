package com.pgd.planillas.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpleadoDto {

    private Integer id;
    private String nombre;
    private Double montoMensual;
    private Boolean isActivo;

}
