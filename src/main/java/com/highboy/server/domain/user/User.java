package com.highboy.server.domain.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 400, unique = true)
    @NotNull
    private String email;

    @Column(length = 20)
    @NotNull
    private String name;

    @Builder
    public User(@NonNull String email,
                @NonNull String name
    ) {
        this.email = email;
        this.name = name;
    }
}