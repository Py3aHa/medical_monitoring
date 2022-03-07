package ru.common.medical_clinic.core.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.common.medical_clinic.core.model.entity.PatientEntity;

import java.util.List;

public interface PatientController {
    /**
     * Saves the patient in the "patient" table in the database of the PatientEntity.
     * @param patientEntity is object of the PatientEntity with creation requirements.
     *                      There is no need to pass the 'id' in the request body
     * @return HttpStatus response '201 CREATED' about creating an object in an entity.
     *         First sentence should end with a period.If the requirements were not met, the HttpStatus '500 Internal Server Error' is returned
     */
    @PostMapping(path = "/")
    ResponseEntity<?> savePatient(@RequestBody PatientEntity patientEntity);

    /**
     * Searches for a patient by primary key in the "patient" table of the database.
     * @param id is a unique key of the PatientEntity object
     * @return object of the PatientEntity with HttpStatus '302 Found',
     *         otherwise HttpStatus '404 Not Found'
     */
    @GetMapping(path = "/{id}")
    ResponseEntity<PatientEntity> getPatientById(@PathVariable(name = "id") Long id);

    /**
     * Searches for all objects of the "patient" table.
     * @return all objects of the PatientEntity as a list whit HttpStatus '200 OK'.
     *         If the table is empty, it returns an empty list
     */
    @GetMapping(path = "/")
    ResponseEntity<List<PatientEntity>> getAllPatients();

    /**
     * Modifies patient data in the "patient" table.
     * @param object is an instance of a class PatientEntity
     *               with a primary key that is stored in a table
     * @return HttpStatus '200 OK' of the successful modification of the entity object in the database,
     *         otherwise returns HttpStatus '304 Not Modified'
     */
    @PutMapping(path = "/")
    ResponseEntity<PatientEntity> updatePatient(@RequestBody PatientEntity object);

    /**
     * Deletes an object from the "patient" table.
     * @param id is a primary key of the PatientEntity object.
     *           If the object was not found in the table, then deletion does not occur
     */
    @DeleteMapping(path = "/{id}")
    void deletePatient(@PathVariable(name = "id") Long id);
}
