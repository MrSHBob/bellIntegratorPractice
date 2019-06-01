package com.example.bellIntegrator.user.userDoc.model;

import com.example.bellIntegrator.doc.model.Doc;
import com.example.bellIntegrator.user.model.User;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.util.Date;

/**
 * Сущность - документ юзера
 */
@Entity
@Table(name = "user_doc")
public class UsersDoc {

    /**
     * идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    /**
     * служебное поле хибернейта
     */
    @Version
    private Integer version;

    /**
     * юзер - которому принадлежит документ
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Соответствующий документ из перечня
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id", nullable = false)
    private Doc doc;

    /**
     * номер документа
     */
    @Column(name = "doc_number", length = 15)
    private String docNumber;

    /**
     * дата выдачи документа
     */
    @Column(name = "doc_date")
    @Temporal(TemporalType.DATE)
    private Date docDate;

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

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }
}
