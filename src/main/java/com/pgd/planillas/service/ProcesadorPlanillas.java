package com.pgd.planillas.service;

import com.pgd.planillas.exception.HayNombreVacioException;
import com.pgd.planillas.exception.IdEsCeroException;
import com.pgd.planillas.exception.MontoNegativoException;
import com.pgd.planillas.model.ResultadoPlanilla;
import com.pgd.planillas.model.dto.EmpleadoDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class ProcesadorPlanillas {

        @Autowired
        private ProveedorMiembrosPlanilla proveedorMiembrosPlanilla;

        public ResultadoPlanilla procesarPlanillas() {
            List<EmpleadoDto> empleados = proveedorMiembrosPlanilla.getEmpleados();

            return ResultadoPlanilla.builder().total(empleados.stream()
                            .filter(EmpleadoDto::getIsActivo)
                            .peek(empleado -> {
                                if(empleado.getId() == 0){
                                    throw new IdEsCeroException("El id no puede ser cero");
                                }
                            })
                            .peek(emp -> {
                                if(!StringUtils.hasLength(emp.getNombre())){
                                    throw new HayNombreVacioException("El nombre no puede ser vacio");
                                }
                            })
                            .peek(emp -> {
                                if(emp.getMontoMensual() < 0.0){
                                    throw new MontoNegativoException("El monto no puede ser negativo");
                                }
                            })
                            .mapToDouble(EmpleadoDto::getMontoMensual)
                            .sum())
                    .empleados(empleados)
                    .build();

        }




}
