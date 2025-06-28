package com.nvminh162.paulshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nvminh162.paulshop.domain.User;
import java.util.List;

//crud: create, read, update, delete
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User eric);

    void deleteById(long id);

    List<User> findOneByEmail(String email);

    List<User> findAll();

    User findById(long id); // null

    boolean existsByEmail(String email);

    User findByEmail(String email);
}
