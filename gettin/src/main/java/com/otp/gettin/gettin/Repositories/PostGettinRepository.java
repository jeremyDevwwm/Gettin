package com.otp.gettin.gettin.Repositories;

import com.otp.gettin.gettin.Entities.PostGettin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostGettinRepository extends JpaRepository<PostGettin, Long> {
}
