package com.pgd.planillas.config;

import com.pgd.planillas.service.ProveedorMiembrosPlanilla;
import com.pgd.planillas.service.ProveedorMiembrosPlanillaImpl;
import com.pgd.planillas.service.ProveedorMiembrosPlanillaRestImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class config {


    @Bean
    public ProveedorMiembrosPlanilla proveedorMiembrosPlanilla(){
        return new ProveedorMiembrosPlanillaImpl(Collections.emptyList());
    }


    /*
    TODO change if you want to test via Postman
    @Bean
    public ProveedorMiembrosPlanillaRestImpl proveedorMiembrosPlanillaRest(){
        return new ProveedorMiembrosPlanillaRestImpl(Collections.emptyList());
    }
    */



}
