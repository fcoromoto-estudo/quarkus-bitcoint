package br.com.fcoromoto.estudo.quarkus.bitcoins.service;

import br.com.fcoromoto.estudo.quarkus.bitcoins.models.Ordem;
import br.com.fcoromoto.estudo.quarkus.bitcoins.models.Usuario;
import br.com.fcoromoto.estudo.quarkus.bitcoins.repository.OrdemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {

    @Inject
    OrdemRepository repository;


    @Transactional
    public void inserir(SecurityContext context, Ordem ordem){

        Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(ordem.getUserId());
        Usuario usuario = usuarioOptional.orElseThrow();

        if(usuario.isUserNameNotEquals(context.getUserPrincipal().getName())){
            throw new RuntimeException("Usuário logado é diferente do usuário informado");
        }

        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        repository.persist(ordem);
    }

    public List<Ordem> listar(){
        return repository.listAll();
    }

}
