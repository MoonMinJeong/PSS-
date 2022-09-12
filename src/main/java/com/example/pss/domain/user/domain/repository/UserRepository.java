package com.example.pss.domain.user.domain.repository;

import com.example.pss.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findByNickname(String nickname);
    Optional<User> findByEmail(String email);
}
