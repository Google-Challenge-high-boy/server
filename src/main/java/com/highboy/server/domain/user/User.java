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
import org.springframework.lang.Nullable;

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

    @Column(length = 30)
    @Nullable
    private String password;

    @Column(length = 20)
    @NotNull
    private String name;

    @Column(unique = true)
    @Nullable
    private Long googleId;

    @Builder
    public User(@NonNull String email,
                @NonNull String name,
                Long googleId,
                String password
    ) {
        this.email = email;
        this.name = name;
        this.googleId = googleId;
        this.password = password;
    }
}