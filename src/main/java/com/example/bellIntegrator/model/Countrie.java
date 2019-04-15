package com.example.bellIntegrator.model;

import javax.persistence.*;

@Entity
@Table(name = "countrie")
public class Countrie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Version
    private Integer version;

    @Column(name = "code", nullable = false)
    private Integer code;

    @Column(name = "name", length = 200)
    private String name;

    public Countrie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
