package com.otp.gettin.gettin.Repositories;

import com.otp.gettin.gettin.Entities.GroupGettin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupGettinRepository extends JpaRepository<GroupGettin, Long> {



}
