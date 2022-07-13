package com.bb8qq.pricecoin.repo;

import com.bb8qq.pricecoin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
