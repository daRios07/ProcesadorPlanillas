package com.pgd.planillas.model;

import com.pgd.planillas.model.dto.EmpleadoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoPlanilla {

    private Double total;
    private List<EmpleadoDto> empleados;
}
