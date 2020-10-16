package br.com.fcoromoto.estudo.quarkus.bitcoins.resources;

import br.com.fcoromoto.estudo.quarkus.bitcoins.models.Ordem;
import br.com.fcoromoto.estudo.quarkus.bitcoins.service.OrdemService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/ordens")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrdemResource {

    @Inject
    OrdemService ordemService;


    @POST
    @RolesAllowed("user")
    public Response inserir(@Context SecurityContext context, Ordem ordem){
       ordemService.inserir(context, ordem);
       return Response.ok(ordem).build();
    }

    @GET
    @RolesAllowed("admin")
    public List<Ordem> listar(){
        return ordemService.listar();
    }
}
