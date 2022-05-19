package io.spielworksbackend.SpielworksBackendAssessment.services;

import io.spielworksbackend.SpielworksBackendAssessment.models.People;
import io.spielworksbackend.SpielworksBackendAssessment.response.PeopleResponse;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;

import static io.spielWorksBackend.jooq.Tables.PEOPLE;

@Service
public class PeopleService {

    @Autowired
    private final io.spielworksbackend.SpielworksBackendAssessment.config.generatedId generatedId;

    @Autowired
    private final DSLContext dslContext;

    public PeopleService(io.spielworksbackend.SpielworksBackendAssessment.config.generatedId generatedId, DSLContext dslContext) {
        this.generatedId = generatedId;
        this.dslContext = dslContext;
    }
    /**
     * This method allow people to be created
     * @param (people object)
     * @return {response}
     * */
    public PeopleResponse addPeople(People people){
        String userId = generatedId.generatedId();
        Long id = Long.valueOf(Integer.parseInt(userId));
            dslContext.insertInto(PEOPLE, PEOPLE.ID, PEOPLE.FIRSTNAME, PEOPLE.LASTNAME)
                    .values(Math.toIntExact(id), people.getFirstName(), people.getLastName())
                    .execute();
            return new PeopleResponse(id);
    }

    /**
     * This method will return all the list of people
     * */
    public List<People> showAllPeople(){
       return dslContext.selectFrom(PEOPLE).fetchInto(People.class);
    }


    /**
     * @param (userId)
     * @return user object
     * */
    public People peopleById(int id){
        try {
            List<People> people = dslContext.select()
                    .from(PEOPLE)
                    .where(PEOPLE.ID.eq(id))
                    .fetchInto(People.class);
            return people.get(0);
        }catch (Exception e){
            throw new IndexOutOfBoundsException();
        }
    }
}
