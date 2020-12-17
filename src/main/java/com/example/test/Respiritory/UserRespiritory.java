package com.example.test.Respiritory;

import com.example.test.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface  UserRespiritory  extends JpaRepository<User, Long>{
    @Query(value = "SELECT * FROM USER  WHERE USER_NAME = :username limit 1", nativeQuery = true)
    User findByUserName(@Param("username") String userName);
}
