package ru.goryacms.dockerInitializr.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
@Table(name = "depends_on")
public class DepependsOn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String valueName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "services_id", nullable = false, updatable = false)
    private Services services;
}
