package com.example.Hiper_gw.dtos;
import com.example.Hiper_gw.models.Band;

public record BandDto( Long id, String band_name, String set_list_id ) {

    public BandDto(Band b){
        this(b.getId(), b.getBand_name(), b.getSet_list_id());
    }

    public Band toBandEntity(){
        return new Band(id, band_name, set_list_id);
    }
    
}
