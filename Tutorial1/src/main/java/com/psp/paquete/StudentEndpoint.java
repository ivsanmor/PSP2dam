package com.psp.paquete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.psp.xml.school.StudentDetailsRequest;
import com.psp.xml.school.PeliculaDetailsResponse;

@Endpoint
public class StudentEndpoint 
{
    private static final String NAMESPACE_URI = "http://www.psp.com/xml/school";
 
    private StudentRepository StudentRepository;
 
    @Autowired
    public StudentEndpoint(StudentRepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
    @ResponsePayload
    public PeliculaDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
        PeliculaDetailsResponse response = new PeliculaDetailsResponse();
        response.setStudent(StudentRepository.findStudent(request.getName()));
 
        return response;
    }
}
