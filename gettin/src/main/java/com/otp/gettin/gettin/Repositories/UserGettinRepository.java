package com.otp.gettin.gettin.Repositories;

import com.otp.gettin.gettin.Entities.UserGettin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGettinRepository extends JpaRepository<UserGettin, Long> {

    UserGettin findByUserLogin(String login);

}
