package com.example.Hiper_gw.mapper;

import com.example.Hiper_gw.dtos.BandDto;
import com.example.Hiper_gw.models.Band;

public class BandMapper {
    public static BandDto convertEntityToDto(Band band){
        BandDto bandDto = new BandDto(band.getId(), band.getBand_name(), band.getSet_list_id());

        return bandDto;
    }


}
