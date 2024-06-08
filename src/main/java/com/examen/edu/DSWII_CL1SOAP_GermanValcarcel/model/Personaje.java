package com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name="personaje")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpersonaje;
    private String nompersonaje;
    private String apepersonaje;
    private Date fechnacpersonaje;
}
