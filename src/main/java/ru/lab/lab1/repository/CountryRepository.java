package ru.lab.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lab.lab1.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}
