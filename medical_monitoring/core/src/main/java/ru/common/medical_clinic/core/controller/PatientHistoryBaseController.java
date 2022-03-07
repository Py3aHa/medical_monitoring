package ru.common.medical_clinic.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ru.common.medical_clinic.core.service.MedicalHistoryService;
import ru.common.medical_clinic.core.service.PatientService;

public class PatientHistoryBaseController {
    @Autowired
    protected PatientService patientService;

    @Autowired
    protected MedicalHistoryService medicalHistoryService;
}
