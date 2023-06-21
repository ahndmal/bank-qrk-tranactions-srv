package com.andmal;

import com.andmal.mono.MonoTransaction;
import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloGrpcService implements TransactionsGrpc {
    @Override
    public Uni<TransReply> getTransaction(TransRequest request) {
        return MonoTransaction.findByIdCustom(request.getId()).map(tr -> {
           return TransReply.newBuilder()
                    .setId(tr.id)
                    .setAccount(tr.account)
                    .setAmount(tr.amount)
                    .setCurrency(tr.currency)
                    .setType(tr.type)
                    .setWhen(tr.when.toString())
                    .setMoment(tr.moment.toString())
                    .build();
        });
    }

    @Override
    public Multi<TransReply> getTransactions(TransRequest request) {
        return null;
    }
}
