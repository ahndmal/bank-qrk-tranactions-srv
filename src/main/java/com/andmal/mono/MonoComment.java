package com.andmal.mono;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name = "comments")
public class MonoComment {
    @Id
    public long id;
    public String body;
    public String title;
    public long parentId;
    @Column(name = "user_id")
    public long userId;
    public LocalDateTime created;
    @Column(name = "last_changed")
    public LocalDateTime lastChanged;

    
}
