package com.blog.blogapp.account;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Account {

    Long id;
    String email;

    //    @JsonIgnore
    String password;
    String firstName;
    String lastName;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
