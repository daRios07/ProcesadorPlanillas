package com.pgd.planillas.controller;

import com.pgd.planillas.model.dto.EmpleadoDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planillas/v1/")
public class EmpleadoController {


    @PostMapping(value = "empleado")
    public EmpleadoDto agregarEmpleado(){
        return new EmpleadoDto();
    }
}
