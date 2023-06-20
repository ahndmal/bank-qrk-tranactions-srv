package com.andmal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class HelloGrpcServiceTest {

    @GrpcClient
    DataGrpcProto dataGrpcProto;

    @Test
    public void testHello() {
//        TransReply reply = dataGrpcProto.
//                (HelloRequest.newBuilder().setName("Neo").build()).await().atMost(Duration.ofSeconds(5));
//        assertEquals("Hello Neo!", reply.getMessage());
    }

}
