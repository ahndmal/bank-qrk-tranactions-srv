package com.andmal.mono.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MonoTransactionDto {
    public long id;
    public long amount;
    public String currency;
    public String type;
    @JsonProperty(value = "user_id")
    public long userId;
    @JsonProperty(value = "account_id")
    public long account;
    @JsonProperty("when_date")
    public LocalDateTime when;
    public Long moment;


}
