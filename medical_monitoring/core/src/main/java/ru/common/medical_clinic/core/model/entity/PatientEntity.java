package ru.common.medical_clinic.core.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "gender", nullable = false)
    private GenderEntity gender;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "birthdayDt", nullable = false)
    private LocalDate birthdayDt;

    @Column(name = "birthPlace", nullable = false)
    private String birthPlace;

    @Column(name = "registration", nullable = false)
    private String registration;

    @Column(name = "passportSeries", nullable = false)
    private String passportSeries;

    @Column(name = "passportNumber", nullable = false)
    private String passportNumber;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "anotherDocument")
    private String anotherDocument;
}

