package ru.lab.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lab.lab1.model.Human;

import java.util.List;
import java.util.Set;

public interface HumanRepository extends JpaRepository<Human, Long> {
    Set<Human> findHumanByIdIn(List<Long> ids);
}
