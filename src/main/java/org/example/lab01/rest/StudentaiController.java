package org.example.lab01.rest;

import lombok.Getter;
import lombok.Setter;
import org.example.lab01.entities.Studentas;
import org.example.lab01.presistence.StudentaiDAO;
import org.example.lab01.rest.contracts.StudentasDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Getter @Setter
@Path("/studentai")
public class StudentaiController {

    private StudentaiDAO studentaiDAO;

    @Path("/{id}")
    @GET
    @Produces("application/json")
    public Response getById(@PathParam("id") final Integer id) {
        Studentas studentas = studentaiDAO.findOne(id);
        if (studentas == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        StudentasDTO studentasDTO = new StudentasDTO();
        studentasDTO.setNumber(studentas.getNumber());
        studentasDTO.setVardas(studentas.getVardas());
        studentasDTO.setPavarde(studentas.getPavarde());
        studentasDTO.setGrupe(studentas.getGrupe().getGrupe());
        studentasDTO.setSpecialybe(studentas.getGrupe().getSpecialybe());
        studentasDTO.setKursas(studentas.getGrupe().getKursas());



        return Response.ok(studentasDTO).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes("application/json")
    @Transactional
    public Response update(@PathParam("id") final Integer studentasId, StudentasDTO studentasData) {
        Studentas existingStudentas = studentaiDAO.findOne(studentasId);
        if (existingStudentas == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        existingStudentas.setNumber(studentasData.getNumber());
        existingStudentas.setVardas(studentasData.getVardas());
        existingStudentas.setPavarde(studentasData.getPavarde());
        studentaiDAO.update(existingStudentas);
        return Response.ok().build();
    }

    @Path("/{id}")
    @DELETE
    @Transactional
    public Response delete(@PathParam("id") final Integer studentasId) {
        studentaiDAO.delete(studentasId);
        return Response.ok().build();
    }
}
