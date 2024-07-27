package com.example.Hiper_gw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hiper_gw.dtos.BandDto;
import com.example.Hiper_gw.mapper.BandMapper;
import com.example.Hiper_gw.models.Band;
import com.example.Hiper_gw.repository.BandRepository;

@Service
public class BandService {
    private BandRepository bandRepository;

    private BandMapper bandMapper;

    @Autowired
    public BandService(final BandRepository bandRepository){
        this.bandRepository = bandRepository;
    }
    
    public BandDto createBand(BandDto bandDto){
        System.out.println("Creating band ! ");
        return new BandDto(bandRepository.saveAndFlush(bandDto.toBandEntity()));
    }

    public List<BandDto> getAllBand(){
        return bandRepository.findAll().stream().map(BandDto::new).toList();
    }

}
