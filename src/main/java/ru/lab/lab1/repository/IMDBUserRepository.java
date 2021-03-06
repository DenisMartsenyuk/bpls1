package ru.lab.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.lab.lab1.model.IMDBUser;

import java.util.List;
import java.util.Optional;

public interface IMDBUserRepository extends JpaRepository<IMDBUser, String> {
    Optional<IMDBUser> findIMDBUserByLogin(String login);

    List<IMDBUser> getAllByEmailIsNotNull();
}
