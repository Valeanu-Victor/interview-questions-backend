package com.hotinterviewquestions.rest.webservices.repository;

import com.hotinterviewquestions.rest.webservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
