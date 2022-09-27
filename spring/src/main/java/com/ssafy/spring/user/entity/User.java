package com.ssafy.spring.user.entity;

import com.ssafy.spring.auth.dto.KakaoUserInfo;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String authId;

//    @Column(nullable = false)
    private String email;

//    @Column(nullable = false)
    private String gender;

    private int birthYear;

    //    @Column(unique = true, nullable = false)
    @Column(unique = true)
    private String userName;

    private String profileImg;

    private String subti;

    @NotNull
    @ColumnDefault("false")
    private boolean isDiet;

    private String refreshToken;
}
