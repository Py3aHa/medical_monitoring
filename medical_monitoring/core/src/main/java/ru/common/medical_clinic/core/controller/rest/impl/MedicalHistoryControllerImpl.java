package ru.common.medical_clinic.core.controller.rest.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.common.medical_clinic.core.controller.PatientHistoryBaseController;
import ru.common.medical_clinic.core.controller.rest.MedicalHistoryController;
import ru.common.medical_clinic.core.model.entity.MedicalHistoryEntity;

import java.util.List;

/**
 * Base class that implements methods of the 'MedicalHistoryController' interface for working with a database.
 */
@RestController
@RequestMapping(path = "/api/medical/history")
public class MedicalHistoryControllerImpl extends PatientHistoryBaseController implements MedicalHistoryController {

    @Override
    @PostMapping(path = "/")
    public ResponseEntity<?> createMedicalHistory(@RequestBody MedicalHistoryEntity medicalHistoryEntity) {
        medicalHistoryService.save(medicalHistoryEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<MedicalHistoryEntity> getMedicalHistoryById(@PathVariable(name = "id") Long id) {
        MedicalHistoryEntity medicalHistoryEntity = medicalHistoryService.findById(id);
        return medicalHistoryEntity != null ?
                new ResponseEntity<>(medicalHistoryEntity, HttpStatus.FOUND) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping(path = "/")
    public ResponseEntity<List<MedicalHistoryEntity>> getAllMedicalHistory() {
        System.out.println("QWEQWEASDASDQWE!@$%^ASF!!!!!!!!!!!!");
        List<MedicalHistoryEntity> medicalHistories = medicalHistoryService.findAll();
        return new ResponseEntity<>(medicalHistories, HttpStatus.OK);
    }

    @Override
    @PutMapping(path = "/")
    public ResponseEntity<MedicalHistoryEntity> updateMedicalHistory(@RequestBody MedicalHistoryEntity medicalHistoryEntity) {
        MedicalHistoryEntity medicalHistory = medicalHistoryService.update(medicalHistoryEntity);
        return medicalHistory != null ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    @DeleteMapping(path = "/{id}")
    public void deleteMedicalHistory(@PathVariable(name = "id") Long id) {
        medicalHistoryService.delete(id);
    }

}
