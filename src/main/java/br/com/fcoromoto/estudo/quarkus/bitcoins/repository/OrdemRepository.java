package br.com.fcoromoto.estudo.quarkus.bitcoins.repository;

import br.com.fcoromoto.estudo.quarkus.bitcoins.models.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {

}
