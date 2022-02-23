package ru.lab.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lab.lab1.model.Country;

import java.util.List;
import java.util.Set;

public interface CountryRepository extends JpaRepository<Country, String> {
    Set<Country> findCountriesByNameIn(List<String> names);
}
