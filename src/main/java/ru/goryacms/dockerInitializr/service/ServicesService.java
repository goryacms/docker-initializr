package ru.goryacms.dockerInitializr.service;

import ru.goryacms.dockerInitializr.dto.ServicesDto;
import ru.goryacms.dockerInitializr.models.Services;

import java.util.List;

public interface ServicesService {
    List<ServicesDto> getAllServices();
}
