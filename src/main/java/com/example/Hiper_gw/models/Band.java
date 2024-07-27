package com.example.Hiper_gw.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bands")
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String band_name;
    private String set_list_id;

    
    public Band(Long id, String band_name, String set_list_id) {
        this.id = id;
        this.band_name = band_name;
        this.set_list_id = set_list_id;
    
    }

    public Band(){
        
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getBand_name() {
        return band_name;
    }


    public void setBand_name(String band_name) {
        this.band_name = band_name;
    }


    public String getSet_list_id() {
        return set_list_id;
    }


    public void setSet_list_id(String set_list_id) {
        this.set_list_id = set_list_id;
    }

    

    
}
