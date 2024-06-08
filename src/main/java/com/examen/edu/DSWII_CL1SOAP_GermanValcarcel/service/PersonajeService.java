package com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.service;

import com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.convert.PersonajeConvert;
import com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.model.Personaje;
import com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.repository.PersonajeRepository;
import com.examen.edu.ws.objects.Personajews;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PersonajeService implements IPersonajeService {
    private PersonajeRepository personajeRepository;
    private PersonajeConvert personajeConvert;

    @Override
    public List<Personajews> listarPersonajes() {
        return personajeConvert.convertPersonajeToPersonajeWs(
                personajeRepository.findAll());
    }

    @Override
    public Personajews obtenerPersonajewsxId(int id) {
        Optional<Personaje> personaje = personajeRepository.findById(id);
        return personaje.map(value ->
                        personajeConvert.convertPersonajeToPersonajeWs(value))
                .orElse(null);
    }

    @Override
    public Personajews registrarActualizarPersonajews(Personajews personajews) {
        Personaje nuevopersonaje = personajeRepository.save(
                personajeConvert.convertPersonajewsToPersonaje(personajews));
        if(nuevopersonaje == null)
            return  null;
        return personajeConvert.convertPersonajeToPersonajeWs(nuevopersonaje);
    }
}
