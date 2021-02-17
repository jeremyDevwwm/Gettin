package com.otp.gettin.gettin.Entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class BelongsId implements Serializable {

    private long UserId;

    private long GroupId;

}
