package com.example.bellIntegrator.userDoc.model;

import com.example.bellIntegrator.doc.model.Doc;
import com.example.bellIntegrator.user.model.User;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user_doc")
public class UsersDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Version
    private Integer version;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id")
    private Doc doc;

    @Column(name = "doc_number", length = 15)
    private String docNumber;

    @Column(name = "doc_date")
//    @Temporal(TemporalType.DATE)                      раскоментить, если потребуется
    private Instant docDate;

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

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }
}
