package com.andmal.mono;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "transactions")
@Entity
public class MonoTransaction extends PanacheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public long amount;
    public String currency;
    public String type;
    @Column(name = "user_id")
    public long userId;
    @Column(name = "account_id")
    public long account;
    @Column(name = "when_date")
    public LocalDateTime when;
    public Long moment;

    public static Uni<MonoTransaction> findByUserId(long userId) {
        return find("user_id", userId).firstResult();
    }

}
