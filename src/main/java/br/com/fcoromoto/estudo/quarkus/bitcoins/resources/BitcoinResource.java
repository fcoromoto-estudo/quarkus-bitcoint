package br.com.fcoromoto.estudo.quarkus.bitcoins.resources;

import br.com.fcoromoto.estudo.quarkus.bitcoins.models.Bitcoin;
import br.com.fcoromoto.estudo.quarkus.bitcoins.services.BitcoinService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bitcoins")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BitcoinResource {

    @Inject
    @RestClient
    BitcoinService bitcoinService;

    @GET
    public List<Bitcoin> get(){
        return bitcoinService.listar();
    }
}
