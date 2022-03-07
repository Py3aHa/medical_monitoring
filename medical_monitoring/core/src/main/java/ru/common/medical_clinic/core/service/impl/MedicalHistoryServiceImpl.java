package ru.common.medical_clinic.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.common.medical_clinic.core.model.entity.MedicalHistoryEntity;
import ru.common.medical_clinic.core.repository.MedicalHistoryRepository;
import ru.common.medical_clinic.core.service.MedicalHistoryService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {
    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Override
    public void save(MedicalHistoryEntity object) {
        LocalDateTime localDateTime = LocalDateTime.now();
        object.setCreateDttm(localDateTime);
        object.setModifyDttm(localDateTime);
        medicalHistoryRepository.save(object);
    }

    @Override
    public MedicalHistoryEntity findById(Long id) {
        return medicalHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<MedicalHistoryEntity> findAll() {
        return medicalHistoryRepository.findAll();
    }

    @Override
    public MedicalHistoryEntity update(MedicalHistoryEntity object) {
        MedicalHistoryEntity medicalHistoryEntity = medicalHistoryRepository.findById(object.getId()).orElse(null);
        if (medicalHistoryEntity != null) {
            medicalHistoryEntity.setModifyDttm(LocalDateTime.now());
            medicalHistoryRepository.save(object);
        }
        return medicalHistoryEntity;
    }

    @Override
    public void delete(Long id) {
        MedicalHistoryEntity medicalHistoryEntity = medicalHistoryRepository.findById(id).orElse(null);
        if (medicalHistoryEntity != null) {
            medicalHistoryRepository.delete(medicalHistoryEntity);
        }
    }
}
