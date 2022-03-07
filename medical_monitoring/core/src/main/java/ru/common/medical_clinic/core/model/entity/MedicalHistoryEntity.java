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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medical_history")
public class MedicalHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient", nullable = false)
    private PatientEntity patient;

    @Column(name = "docNumber", nullable = false)
    private String docNumber;

    @Column(name = "createDttm")
    private LocalDateTime createDttm;

    @Column(name = "modifyDttm")
    private LocalDateTime modifyDttm;

    @Column(name = "doctor")
    private String doctor;

    @Column(name = "diagnosis")
    private String diagnosis;

    @OneToOne
    @JoinColumn(name = "medicalHistory")
    private MedicalHistoryEntity medicalHistory;
}
