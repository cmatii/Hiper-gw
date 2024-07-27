package com.example.Hiper_gw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hiper_gw.models.Band;

@Repository
public interface BandRepository extends JpaRepository<Band, Long> {

}
