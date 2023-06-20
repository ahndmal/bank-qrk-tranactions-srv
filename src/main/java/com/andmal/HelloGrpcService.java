package com.andmal;

import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloGrpcService implements TransactionsGrpc {

    @Override
    public Uni<TransReply> getTransaction(TransRequest request) {
        return Uni.createFrom().item(TransReply.newBuilder().build());
    }
}
