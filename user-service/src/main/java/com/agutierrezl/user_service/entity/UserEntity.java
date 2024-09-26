package com.agutierrezl.user_service.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document("user")
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String[] roles;
}
