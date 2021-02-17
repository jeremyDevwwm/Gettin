package com.otp.gettin.gettin.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="GroupGettin")
@NoArgsConstructor
public class GroupGettin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long GroupId;
    private String GroupName;
    private String GroupTag;
}
