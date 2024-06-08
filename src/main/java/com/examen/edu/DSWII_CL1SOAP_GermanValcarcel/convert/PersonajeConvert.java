package com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.convert;

import com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.model.Personaje;
import com.examen.edu.ws.objects.Personajews;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class PersonajeConvert {
    public Personaje convertPersonajewsToPersonaje(Personajews personajews){
        Personaje personaje = new Personaje();
        personaje.setIdpersonaje(personajews.getIdpersonaje());
        personaje.setNompersonaje(personajews.getNompersonaje());
        personaje.setApepersonaje(personajews.getApepersonaje());

        XMLGregorianCalendar fechnacXML = personajews.getFechanacpersonaje();
        if (fechnacXML != null) {
            Date fechnacDate = fechnacXML.toGregorianCalendar().getTime();
            personaje.setFechnacpersonaje(fechnacDate);
        } else {
            personaje.setFechnacpersonaje(null);
        }

        return personaje;

    }

    public List<Personaje> convertPersonajewsToPersonaje(List<Personajews> domiciliows){
        List<Personaje> personajeList = new ArrayList<>();
        domiciliows.forEach(dom ->{
            personajeList.add(convertPersonajewsToPersonaje(dom));
        });
        return personajeList;
    }
    public Personajews convertPersonajeToPersonajeWs(Personaje personaje){
        Personajews personajews = new Personajews();
        personajews.setIdpersonaje(personaje.getIdpersonaje());
        personajews.setNompersonaje(personaje.getNompersonaje());
        personajews.setApepersonaje(personaje.getApepersonaje());
        Date fechnacDate = personaje.getFechnacpersonaje();
        if (fechnacDate != null) {
            try {
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTime(fechnacDate);
                XMLGregorianCalendar fechnacXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
                personajews.setFechanacpersonaje(fechnacXML);
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }
        } else {
            personajews.setFechanacpersonaje(null);
        }

        return personajews;
    }
    public List<Personajews> convertPersonajeToPersonajeWs(List<Personaje> personaje){
        List<Personajews> personajeList = new ArrayList<>();
        personaje.forEach(dom ->{
            personajeList.add(convertPersonajeToPersonajeWs(dom));
        });
        return personajeList;
    }


}