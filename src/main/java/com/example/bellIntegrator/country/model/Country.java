package com.example.bellIntegrator.country.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Сущность - "Страна".
 */
@Entity
@Table(name = "country")
public class Country {

    /**
     * идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    /**
     * служебное полу хибернейта
     */
    @Version
    private Integer version;

    /**
     * код страны
     */
    @Column(name = "code", nullable = false, unique = true)
    private Integer code;

    /**
     * наименование страны
     */
    @Column(name = "name", length = 200)
    private String name;

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
