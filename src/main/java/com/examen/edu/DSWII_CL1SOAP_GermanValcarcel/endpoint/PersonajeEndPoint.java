package com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.endpoint;

import com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.exception.NotFoundException;
import com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.service.PersonajeService;
import com.examen.edu.ws.objects.*;
import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@AllArgsConstructor
public class PersonajeEndPoint{
    private PersonajeService personajeService;
    private static final String NAMESPACE_URL = "http://www.edu.examen.com/ws/objects";

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getPersonajesRequest")
    @ResponsePayload
    public GetPersonajesResponse getPersonaje(@RequestPayload
                                              GetPersonajesRequest request){
        GetPersonajesResponse response = new GetPersonajesResponse();
        response.getPersonajes().addAll(personajeService.listarPersonajes());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getPersonajeRequest")
    @ResponsePayload
    public GetPersonajeResponse getDomicilio(@RequestPayload
                                             GetPersonajeRequest request){
        GetPersonajeResponse response = new GetPersonajeResponse();
        Personajews personajews = personajeService.obtenerPersonajewsxId(request.getId());
        if(personajews == null)
            throw new NotFoundException("El personaje con el ID " + request.getId()+" no existe!");
        response.setPersonaje(personajews);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "postPersonajeRequest")
    @ResponsePayload
    public PostPersonajeResponse savePersonaje(@RequestPayload
                                               PostPersonajeRequest request){
        PostPersonajeResponse response = new PostPersonajeResponse();
        response.setPersonaje(personajeService.registrarActualizarPersonajews(
                request.getPersonaje()));
        return response;
    }


}
