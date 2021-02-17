package com.otp.gettin.gettin.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "UsersGettin")
@NoArgsConstructor
public class UserGettin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long UserId;
    @Column(name="UserNickname")
    private String userNickname;

    @Column(name="UserMail")
    private String userMail;

    @Column(name="UserLogin")
    private String userLogin;

    @Column(name="UserPassword")
    private String userPassword;

    @Column(name="UserRole")
    private int userRole;
    @ManyToOne
    @JoinColumn(name="GroupId", referencedColumnName = "GroupId")
    private GroupGettin groupGettin;
}
