package ru.goryacms.dockerInitializr.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import ru.goryacms.dockerInitializr.models.*;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicesDto {
    private String name;

    private String image;
    private Boolean useImage;

    private String restart;
    private Boolean useRestart;

    private String memLimit;
    private Boolean useMemLimit;

    private String memswapLimit;
    private Boolean useMemswapLimit;

    private String hostname;
    private Boolean useHostname;

    private String build;
    private Boolean useBuild;

    private String containerName;
    private Boolean useContainerName;

    private String command;
    private Boolean useCommand;

    private List<PortDto> ports;
    private Boolean usePorts;
    private List<ExposeDto> exposes;
    private Boolean useExpose;
    private List<EnvironmentDto> environments;
    private Boolean useEnvironments;

    private List<NetworkDto> networks;
    private Boolean useNetworks;

    private List<VolumeDto> volumes;
    private Boolean useVolumes;

    private List<DepependsOnDto> depependsOns;
    private Boolean useDependsOn;
}
