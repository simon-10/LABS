package edu.mum.cs.cs425.demos.elibrary_springsec_1.repository;

import edu.mum.cs.cs425.demos.elibrary_springsec_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}
