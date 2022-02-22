package ru.lab.lab1.service.impl;

import ru.lab.lab1.model.Movie;
import ru.lab.lab1.service.AdminService;

public class AdminServiceImpl implements AdminService {

    @Override
    public Movie getMovie(Long id) {
        return new Movie();
    }
}
