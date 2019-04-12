package com.example.bellIntegrator.model;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Version
    private Integer version;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "full_name", length = 200)
    private String fullName;

    @Column(name = "inn", length = 20)
    private String inn;

    @Column(name = "kpp", length = 9)
    private String kpp;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "phone", length = 15)
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "organization_id")
    private List<Office> offices;

    @Column(name = "is_active")
    private Boolean isActive;
}
