package com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.service;

import com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.model.Personaje;
import com.examen.edu.ws.objects.Personajews;

import java.util.List;

public interface IPersonajeService {
   List<Personajews> listarPersonajes();
   Personajews obtenerPersonajewsxId(int id);
   Personajews registrarActualizarPersonajews(Personajews personajews);
}
