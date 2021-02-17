package com.otp.gettin.gettin.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="PostGettin")
@NoArgsConstructor
public class PostGettin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long PostId;
    private String PostContent;
    private long PostRating;

    @ManyToOne
    @JoinColumn(name="GroupId", referencedColumnName = "GroupId")
    private GroupGettin groupGettin;

    @ManyToOne
    @JoinColumn(name="UserId", referencedColumnName = "UserId")
    private UserGettin userGettin;
}
