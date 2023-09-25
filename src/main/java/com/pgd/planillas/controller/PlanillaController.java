package com.pgd.planillas.controller;

import com.pgd.planillas.model.ResultadoPlanilla;
import com.pgd.planillas.service.PlanillasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/planillas/v1/")
public class PlanillaController {

    @Autowired
    private PlanillasService planillasService;

    @GetMapping(value = "planilla")
    public ResultadoPlanilla procesarPlanillas() {
        return planillasService.procesarPlanillas();
    }


}
