package com.andmal.repo;

import com.andmal.mono.MonoUser;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MonoUserRepo implements PanacheRepository<MonoUser> {
    public Uni<MonoUser> findByName(String name){
        return find("name", name).firstResult();
    }
}
