package com.pgd.planillas.service;

import com.pgd.planillas.model.dto.EmpleadoDto;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorMiembrosPlanillaImpl  extends ProveedorMiembrosPlanilla{

    private List<EmpleadoDto> listaEmpleados;

    @Override
    public List<EmpleadoDto> getEmpleados() {

        return listaEmpleados;
        /*
        Random r = new Random();
        int low = 1;
        int high = 11;
        int result = r.nextInt(high-low) + low;
        return mockEmpleados(result);
        */

    }

    private List<EmpleadoDto> mockEmpleados(Integer idPlanilla) {
        List<EmpleadoDto> result = Collections.emptyList();
        switch (idPlanilla) {
            case 1:
                result =  getEmptyList();
                break;
            case 2:
                result = getEmpleadosWithCeroId();
                break;
            case 3:
                result = getEmpleadosWithNombreVacio();
                break;
            case 4:
                result = getEmpleadosWithMontoNegativo();
                break;
            default:
                result = getEmpleadosMock();
        }
        return result;

    }

    private List<EmpleadoDto> getEmpleadosWithMontoNegativo() {
        List<EmpleadoDto> result = new java.util.ArrayList<>(getEmpleadosMock());
        EmpleadoDto empleadoDto = EmpleadoDto.builder()
                .id(3)
                .nombre("Maria")
                .isActivo(true)
                .montoMensual(-1000.0)
                .build();
        result.add(empleadoDto);
        return result;
    }

    private List<EmpleadoDto> getEmpleadosWithNombreVacio() {
        List<EmpleadoDto> result = new java.util.ArrayList<>(getEmpleadosMock());
        EmpleadoDto empleadoDto = EmpleadoDto.builder()
                .id(0)
                .nombre("")
                .isActivo(true)
                .montoMensual(1000.0)
                .build();
        result.add(empleadoDto);
        return result;
    }

    private List<EmpleadoDto> getEmpleadosWithCeroId() {
        List<EmpleadoDto> result = new java.util.ArrayList<>(getEmpleadosMock());
        EmpleadoDto empleadoDto = EmpleadoDto.builder()
                .id(0)
                .nombre("Camila")
                .isActivo(true)
                .montoMensual(1000.0)
                .build();
        result.add(empleadoDto);
        return result;
    }

    private List<EmpleadoDto> getEmptyList() {
        return Collections.emptyList();
    }

    private List<EmpleadoDto> getEmpleadosMock() {
        EmpleadoDto empleadoDto = EmpleadoDto.builder()
                .id(1)
                .nombre("Juan")
                .isActivo(true)
                .montoMensual(1000.0)
                .build();
        EmpleadoDto empleadoDto2 = EmpleadoDto.builder()
                .id(2)
                .nombre("Pedro")
                .isActivo(false)
                .montoMensual(2000.0)
                .build();
        EmpleadoDto empleadoDto3 = EmpleadoDto.builder()
                .id(3)
                .nombre("Ana")
                .isActivo(true)
                .montoMensual(2000.0)
                .build();

        return List.of(empleadoDto, empleadoDto2, empleadoDto3);
    }

}
