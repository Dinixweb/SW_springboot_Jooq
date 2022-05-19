package io.spielworksbackend.SpielworksBackendAssessment.controllers;

import io.spielworksbackend.SpielworksBackendAssessment.models.People;
import io.spielworksbackend.SpielworksBackendAssessment.response.PeopleResponse;
import io.spielworksbackend.SpielworksBackendAssessment.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PeopleController {

    @Autowired
    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    /**
    * @param (people)
     * @return (response)
     * This method will create a new people
    * */
    @PostMapping(value = "/people", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addPeople(@RequestBody People people){
        PeopleResponse peopleResponse =  peopleService.addPeople(people);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(peopleResponse.getId())
                .toUri();
        System.out.println(location);
        return ResponseEntity.created(location).build();

    }

    /**
     * this will return all the people
     * @return (List)
     */
    @GetMapping(value = "/people", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<People>> getPeopleList(){
        List<People> people = peopleService.showAllPeople();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    /**
     * @param (id)
     * @return (Object)
     * this will return people by their Id
     */
    @GetMapping(value = "/people/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public People getPeopleById(@PathVariable("id") int id){
           return peopleService.peopleById(id);
    }
}
