package ru.lab.lab1.service;

import ru.lab.lab1.dto.SendingEmailDTO;

public interface EmailService {
    void send(SendingEmailDTO sendingEmailDTO);
}
