package ru.goryacms.dockerInitializr.repository;

import org.springframework.data.repository.CrudRepository;
import ru.goryacms.dockerInitializr.models.Services;

public interface ServicesRepository extends CrudRepository<Services, Long> {
}