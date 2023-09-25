package com.pgd.planillas.service;

import com.pgd.planillas.model.dto.EmpleadoDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class ProveedorMiembrosPlanilla {


    public abstract List<EmpleadoDto> getEmpleados();


}
