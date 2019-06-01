package com.example.bellIntegrator.organization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Сущность - организация.
 */
@Entity
@Table(name = "organization")
public class Organization {

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
     * название организации
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * полное наименование организации
     */
    @Column(name = "full_name", length = 200)
    private String fullName;

    /**
     * ИНН - индивидуальный налоговый номер
     */
    @Column(name = "inn", length = 20)
    private String inn;

    /**
     * КПП - код причины постановки на учет
     */
    @Column(name = "kpp", length = 9)
    private String kpp;

    /**
     * адрес
     */
    @Column(name = "address", length = 100)
    private String address;

    /**
     * телефон
     */
    @Column(name = "phone", length = 15)
    private String phone;

    /**
     * неведомое поле
     */
    @Column(name = "is_active")
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
