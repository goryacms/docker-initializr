package ru.goryacms.dockerInitializr.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "services")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private String image;
    private Boolean useImage = false;

    private String restart;
    private Boolean useRestart = false;

    @Column(name = "mem_limit")
    private String memLimit;
    private Boolean useMemLimit = false;

    @Column(name = "memswap_limit")
    private String memswapLimit;
    private Boolean useMemswapLimit = false;

    private String hostname;
    private Boolean useHostname = false;

    private String build;
    private Boolean useBuild = false;

    @Column(name = "container_name")
    private String containerName;
    private Boolean useContainerName = false;

    private String command;
    private Boolean useCommand = false;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "services")
    private List<Port> ports;
    private Boolean usePorts = false;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "services")
    private List<Expose> exposes;
    private Boolean useExpose = false;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "services")
    private List<Environment> environments;
    private Boolean useEnvironments = false;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "services")
    private List<Network> networks;
    private Boolean useNetworks = false;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "services")
    private List<Volume> volumes;
    private Boolean useVolumes = false;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "services")
    private List<DepependsOn> depependsOns;
    private Boolean useDependsOn = false;
}
