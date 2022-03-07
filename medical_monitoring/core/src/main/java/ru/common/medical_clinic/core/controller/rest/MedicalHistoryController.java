package ru.common.medical_clinic.core.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.common.medical_clinic.core.model.entity.MedicalHistoryEntity;

import java.util.List;

public interface MedicalHistoryController {
    /**
     * Saves the medical history of the patient in the "medical_history" table in the database
     * of the MedicalHistoryEntity.
     * @param medicalHistoryEntity is object of the MedicalHistoryEntity with creation requirements.
     *                      There is no need to pass the 'id' in the request body
     * @return HttpStatus response '201 CREATED' about creating an object in an entity.
     *         If the requirements were not met, the HttpStatus '500 Internal Server Error' is returned
     */
    @PostMapping(path = "/")
    ResponseEntity<?> createMedicalHistory(@RequestBody MedicalHistoryEntity medicalHistoryEntity);

    /**
     * Searches for a medical history by primary key in the "medical_history" table of the database.
     * @param id is a unique key of the MedicalHistoryEntity object
     * @return object of the MedicalHistoryEntity with HttpStatus '302 Found',
     *         otherwise HttpStatus '404 Not Found'
     */
    @GetMapping(path = "/{id}")
    ResponseEntity<MedicalHistoryEntity> getMedicalHistoryById(@PathVariable(name = "id") Long id);

    /**
     * Searches for all objects of the "medical_history" table.
     * @return all objects of the MedicalHistoryEntity as a list whit HttpStatus '200 OK'.
     *         If the table is empty, it returns an empty list
     */
    @GetMapping(path = "/")
    ResponseEntity<List<MedicalHistoryEntity>> getAllMedicalHistory();

    /**
     * Modifies medical history data of patient in the "medical_history" table.
     * @param medicalHistoryEntity is an instance of a class MedicalHistoryEntity
     *               with a primary key that is stored in a table
     * @return HttpStatus '200 OK' of the successful modification of the entity object in the database,
     *         otherwise returns HttpStatus '304 Not Modified'
     */
    @PutMapping(path = "/")
    ResponseEntity<MedicalHistoryEntity> updateMedicalHistory(@RequestBody MedicalHistoryEntity medicalHistoryEntity);

    /**
     * Deletes an object from the "medical_history" table.
     * @param id is a primary key of the MedicalHistoryEntity object.
     *           If the object was not found in the table, then deletion does not occur
     */
    @DeleteMapping(path = "/{id}")
    void deleteMedicalHistory(@PathVariable(name = "id") Long id);
}
