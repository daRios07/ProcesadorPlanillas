package com.pgd.planillas.service;

import com.pgd.planillas.exception.HayNombreVacioException;
import com.pgd.planillas.exception.IdEsCeroException;
import com.pgd.planillas.exception.MontoNegativoException;
import com.pgd.planillas.model.ResultadoPlanilla;
import com.pgd.planillas.model.dto.EmpleadoDto;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProcesadorPlanillasTest {


    private ProcesadorPlanillas target;
    private ProveedorMiembrosPlanilla proveedorMiembrosPlanilla;


    @Test
    public void testProcesarPlanillas() {

        proveedorMiembrosPlanilla = new ProveedorMiembrosPlanillaImpl(getEmpleadosMock());
        target = new ProcesadorPlanillas(proveedorMiembrosPlanilla);
        ResultadoPlanilla resultadoPlanilla = target.procesarPlanillas();
        assertNotNull(resultadoPlanilla);
        assertEquals(3000.0, resultadoPlanilla.getTotal());
    }

    @Test

    public void testProcesarPlanillasMontoNegativo() {

        List<EmpleadoDto> empleados = getEmpleadosMock();
        empleados.get(0).setMontoMensual(-1000.0);
        proveedorMiembrosPlanilla = new ProveedorMiembrosPlanillaImpl(empleados);
        target = new ProcesadorPlanillas(proveedorMiembrosPlanilla);
        Exception exception = assertThrows(MontoNegativoException.class, () -> {
            target.procesarPlanillas();
        });
        String expectedMessage = "El monto no puede ser negativo";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void testProcesarPlanillasIdCero() {

        List<EmpleadoDto> empleados = getEmpleadosMock();
        empleados.get(2).setId(0);
        proveedorMiembrosPlanilla = new ProveedorMiembrosPlanillaImpl(empleados);
        target = new ProcesadorPlanillas(proveedorMiembrosPlanilla);
        Exception exception = assertThrows(IdEsCeroException.class, () -> {
            target.procesarPlanillas();
        });
        String expectedMessage = "El id no puede ser cero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testProcesarPlanillasNombreVacio() {

        List<EmpleadoDto> empleados = getEmpleadosMock();
        empleados.get(0).setNombre("");
        proveedorMiembrosPlanilla = new ProveedorMiembrosPlanillaImpl(empleados);
        target = new ProcesadorPlanillas(proveedorMiembrosPlanilla);
        Exception exception = assertThrows(HayNombreVacioException.class, () -> {
            target.procesarPlanillas();
        });
        String expectedMessage = "El nombre no puede ser vacio";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testProcesarPlanillasListaVacia() {

        List<EmpleadoDto> empleados = Collections.emptyList();
        proveedorMiembrosPlanilla = new ProveedorMiembrosPlanillaImpl(empleados);
        target = new ProcesadorPlanillas(proveedorMiembrosPlanilla);
        ResultadoPlanilla resultadoPlanilla = target.procesarPlanillas();
        assertNotNull(resultadoPlanilla);
        assertEquals(0.0, resultadoPlanilla.getTotal());
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