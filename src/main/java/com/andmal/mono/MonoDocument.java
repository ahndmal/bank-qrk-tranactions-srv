package com.andmal.mono;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name = "documents")
public class MonoDocument {
    @Id
    public long id;
    public String title;
    @Column(name = "file_type")
    public String type;
    @Column(name = "page_id")
    public long pageId;
    @Column(name = "user_id")
    public long userId;
    public LocalDateTime created;
    @Column(name = "last_changed")
    public LocalDateTime lastChanged;

    
}
