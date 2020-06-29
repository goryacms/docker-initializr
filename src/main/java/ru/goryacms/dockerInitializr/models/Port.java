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
@Table(name = "port")
public class Port {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer app;
    private Integer docker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "services_id", nullable = false, updatable = false)
    private Services services;
}
