package com.pgd.planillas.service;

import com.pgd.planillas.model.ResultadoPlanilla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanillasService {

    @Autowired
    private ProcesadorPlanillas procesadorPlanillas;

    public ResultadoPlanilla procesarPlanillas() {
        return procesadorPlanillas.procesarPlanillas();
    }
}
