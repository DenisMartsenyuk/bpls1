package ru.lab.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lab.lab1.model.Human;

public interface HumanRepository extends JpaRepository<Human, Long> {
}
