package br.com.fcoromoto.estudo.quarkus.bitcoins.resources;

import br.com.fcoromoto.estudo.quarkus.bitcoins.models.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {


    @POST
    @PermitAll
    @Transactional
    public Response inserir(Usuario usuario){
        Usuario.inserir(usuario);
        return Response.ok(usuario).build();
    }

    @GET
    @RolesAllowed("admin")
    public List<Usuario> listar(){
        return Usuario.listAll();
    }
}
