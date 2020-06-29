package ru.goryacms.dockerInitializr.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.goryacms.dockerInitializr.dto.EnvironmentDto;
import ru.goryacms.dockerInitializr.dto.PortDto;
import ru.goryacms.dockerInitializr.dto.ServicesDto;
import ru.goryacms.dockerInitializr.dto.VolumeDto;
import ru.goryacms.dockerInitializr.repository.ServicesRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ServicesServiceImpl implements ServicesService {
    private final ServicesRepository repository;
    private final ModelMapper mapper;

    public ServicesServiceImpl(ServicesRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ServicesDto> getAllServices() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(it -> {
//                    List<EnvironmentDto> environmentDtos = it.getEnvironments().stream()
//                            .map(env -> EnvironmentDto.builder()
//                                    .keyName(env.getKeyName())
//                                    .valueName(env.getValueName())
//                                    .build())
//                            .collect(Collectors.toList());
//
//                    List<PortDto> portDtos = it.getPorts().stream()
//                            .map(port -> PortDto.builder()
//                                    .app(port.getApp())
//                                    .docker(port.getDocker())
//                                    .build())
//                            .collect(Collectors.toList());
//
//                    List<VolumeDto> volumeDtos = it.getVolumes().stream()
//                            .map(port -> VolumeDto.builder()
//                                    .app(port.getApp())
//                                    .docker(port.getDocker())
//                                    .build())
//                            .collect(Collectors.toList());
//
//                    return ServicesDto.builder()
//                            .image(it.getImage())
//                            .name(it.getName())
//                            .useRestart(it.getUseRestart())
//                            .restart(it.getRestart())
//                            .useEnvironments(it.getUseEnvironments())
//                            .environments(environmentDtos)
//                            .usePorts(it.getUsePorts())
//                            .ports(portDtos)
//                            .useVolumes(it.getUseVolumes())
//                            .volumes(volumeDtos)
//                            .build();
                    return mapper.map(it, ServicesDto.class);
                })
                .collect(Collectors.toList());
    }

}
