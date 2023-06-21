package com.andmal.rest;

import com.andmal.mono.MonoTransaction;
import com.andmal.mono.MonoUser;
import com.andmal.mono.dto.MonoTransactionDto;
import com.andmal.repo.MonoUserRepo;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceUnit;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Path("/transactions")
public class TransResource {
    @Inject
//    @PersistenceUnit("")
    MonoUserRepo userRepo;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MonoTransactionDto> getTransactions(@QueryParam("limit") int limit) {
        return MonoTransaction.getAll().await().indefinitely().stream().map(tre -> {
            MonoTransactionDto dto = new MonoTransactionDto();
            dto.account = tre.account;
            dto.amount = tre.amount;
            return dto;
        }).collect(Collectors.toList());
    }

    @WithSession
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<MonoTransactionDto> getTransById(@PathParam("id") long id) {
        return MonoTransaction.findByIdCustom(id).map(tre -> {
            MonoTransactionDto dto = new MonoTransactionDto();
            dto.account = tre.account;
            dto.amount = tre.amount;
            dto.type = tre.type;
            dto.userId = tre.userId;
            dto.moment = tre.moment;
            dto.when = tre.when;
            return dto;
        });
//        return userRepo.findById(id).map(t -> t.getName());
    }


}
