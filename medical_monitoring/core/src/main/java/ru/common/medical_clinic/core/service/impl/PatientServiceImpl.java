package ru.common.medical_clinic.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.common.medical_clinic.core.model.entity.PatientEntity;
import ru.common.medical_clinic.core.repository.PatientRepository;
import ru.common.medical_clinic.core.service.PatientService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientEntityRepository;

    @Override
    public void save(PatientEntity patientEntity) {
        patientEntityRepository.save(patientEntity);
    }

    @Override
    public PatientEntity findById(Long id) {
        return patientEntityRepository.findById(id).orElse(null);
    }

    @Override
    public List<PatientEntity> findAll() {
        return patientEntityRepository.findAll();
    }

    @Override
    public PatientEntity update(PatientEntity object) {
        PatientEntity patientEntity = patientEntityRepository.findById(object.getId()).orElse(null);

        if (patientEntity != null) {
            patientEntityRepository.save(object);
        }
        return patientEntity;
    }

    @Override
    public void delete(Long id) {
        PatientEntity patientEntity = patientEntityRepository.findById(id).orElse(null);
        if (patientEntity != null) {
            patientEntityRepository.delete(patientEntity);
        }
    }
}
