package com.example.Hiper_gw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hiper_gw.dtos.BandDto;
import com.example.Hiper_gw.service.BandService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/bands")
public class BandController {

    @Autowired
    private BandService bandService;

    public BandController(BandService bandService){
        this.bandService = bandService;
    }

    @PostMapping
    public BandDto createBand(@RequestBody BandDto bandDto){
        return bandService.createBand(bandDto);

    }
    
}
