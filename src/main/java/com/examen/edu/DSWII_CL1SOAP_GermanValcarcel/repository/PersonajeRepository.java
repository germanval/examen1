package com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.repository;

import com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository <Personaje,Integer> {

}
