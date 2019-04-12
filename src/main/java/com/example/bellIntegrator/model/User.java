package com.example.bellIntegrator.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Version
    private Integer version;


    @Column(name = "office_id", nullable = false)                               //ADD FOREIGN KEY
    private Long officeId;

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

    @Column(name = "doc_code")                                               //ADD FOREIGN KEY
    private Integer docCode;

    @Column(name = "doc_number", length = 15)
    private String docNumber;

    @Column(name = "doc_date")
    private Instant docDate;

    @Column(name = "citizenship_code")                                               //ADD FOREIGN KEY
    private Integer citizenshipCode;

    @Column(name = "is_identified")
    private Boolean isIdentified;
}
