package com.example.bellIntegrator.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Version
    private Integer version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Office office;

    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    @Column(name = "second_name", length = 30)
    private String secondName;

    @Column(name = "middle_name", length = 30)
    private String middleName;

    @Column(name = "position", length = 50, nullable = false)
    private String position;

    @Column(name = "phone", length = 15)
    private String phone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UsersDoc> usersDocs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Countrie citizenship;

    public User() {
    }

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

    public List<UsersDoc> getUsersDocs() {
        return usersDocs;
    }

    public void setUsersDocs(List<UsersDoc> usersDocs) {
        this.usersDocs = usersDocs;
    }

    public Countrie getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Countrie citizenship) {
        this.citizenship = citizenship;
    }
}
