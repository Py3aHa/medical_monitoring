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
import ru.common.medical_clinic.core.controller.rest.PatientController;
import ru.common.medical_clinic.core.model.entity.PatientEntity;

import java.util.List;

/**
 * Base class that implements methods of the 'PatientController' interface for working with a database.
 */
@RestController
@RequestMapping(path = "/api/medical/patient")
public class PatientControllerImpl extends PatientHistoryBaseController implements PatientController {
    @Override
    @PostMapping(path = "/")
    public ResponseEntity<?> savePatient(@RequestBody PatientEntity patientEntity) {
        patientService.save(patientEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<PatientEntity> getPatientById(@PathVariable(name = "id") Long id) {
        PatientEntity patientEntity = patientService.findById(id);
        return patientEntity != null ?
                new ResponseEntity<>(patientEntity, HttpStatus.FOUND) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping(path = "/")
    public ResponseEntity<List<PatientEntity>> getAllPatients() {
        List<PatientEntity> patients = patientService.findAll();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @Override
    @PutMapping(path = "/")
    public ResponseEntity<PatientEntity> updatePatient(@RequestBody PatientEntity object) {
        PatientEntity patientEntity = patientService.update(object);
        return patientEntity != null ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    @DeleteMapping(path = "/{id}")
    public void deletePatient(@PathVariable(name = "id") Long id) {
        patientService.delete(id);
    }
}
