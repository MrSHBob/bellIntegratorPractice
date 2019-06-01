package com.example.bellIntegrator.user.model;

import com.example.bellIntegrator.country.model.Country;
import com.example.bellIntegrator.office.model.Office;
import com.example.bellIntegrator.user.userDoc.model.UsersDoc;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Сущность - юзер
 */
@Entity
@Table(name = "user")
public class User {

    /**
     * идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * служебное поле хибернейта
     */
    @Version
    private Integer version;

    /**
     * офис - к которому приписан юзер
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

    /**
     * Имя
     */
    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "second_name", length = 30)
    private String secondName;

    /**
     * Отчество
     */
    @Column(name = "middle_name", length = 30)
    private String middleName;

    /**
     * должность
     */
    @Column(name = "position", length = 50, nullable = false)
    private String position;

    /**
     * телефон
     */
    @Column(name = "phone", length = 15)
    private String phone;

    /**
     * документ юзера
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, optional = false)
    private UsersDoc userDoc;

    /**
     * гражданство
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenship_id")
    private Country citizenship;

    /**
     * еще какое-то поле
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UsersDoc getUsersDocs() {
        return userDoc;
    }

    public void setUsersDocs(UsersDoc userDoc) {
        this.userDoc = userDoc;
    }

    public Country getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Country citizenship) {
        this.citizenship = citizenship;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public UsersDoc getUserDoc() {
        return userDoc;
    }

    public void setUserDoc(UsersDoc userDoc) {
        this.userDoc = userDoc;
    }
}
