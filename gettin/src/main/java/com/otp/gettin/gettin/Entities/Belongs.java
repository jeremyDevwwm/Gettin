package com.otp.gettin.gettin.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@IdClass(BelongsId.class)
@Table(name = "UsersGettin")
@NoArgsConstructor
public class Belongs {

    @Id
    private long UserId;

    @Id
    private long GroupId;
}
