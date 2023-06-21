package com.andmal.mono;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name = "accounts")
public class MonoAccount extends PanacheEntity {
    public long id;
    public long amount;
    @Column(name = "user_id")
    public long userId;
    public String name;
    public String type;
    public LocalDateTime created;

}
