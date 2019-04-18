package com.example.bellIntegrator.model;

import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "users_docs")
public class UsersDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Version
    private Integer version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "doc_code")
    private Integer docCode;

    @Column(name = "doc_number", length = 15)
    private String docNumber;

    @Column(name = "doc_date")
//    @Temporal(TemporalType.DATE)                      раскоментить, если потребуется
    private Instant docDate;

    @Column(name = "is_identified")
    private Boolean isIdentified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDocCode() {
        return docCode;
    }

    public void setDocCode(Integer docCode) {
        this.docCode = docCode;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Instant getDocDate() {
        return docDate;
    }

    public void setDocDate(Instant docDate) {
        this.docDate = docDate;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }
}
