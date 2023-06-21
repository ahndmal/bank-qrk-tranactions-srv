package com.andmal.rest;

import com.andmal.mono.MonoTransaction;
import com.andmal.mono.dto.MonoTransactionDto;
import com.andmal.repo.MonoUserRepo;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/transactions")
public class TransResource {
    @Inject
//    @PersistenceUnit("")
    MonoUserRepo userRepo;

    @WithSession
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<MonoTransactionDto>> getTransactions(@QueryParam("limit") int limit) {
        return MonoTransaction.getAll().map(trList -> {
            var dtoList = trList.stream().map(tre -> {
                MonoTransactionDto dto = new MonoTransactionDto();
                dto.account = tre.account;
                dto.amount = tre.amount;
                return dto;
            }).toList().subList(0, limit);
            return dtoList;
        });
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
    }


}
