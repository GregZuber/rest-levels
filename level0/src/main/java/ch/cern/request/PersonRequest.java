package ch.cern.request;

import ch.cern.domain.Person;

/**
 * Created by g on 11.03.17.
 */
public class PersonRequest {
    private String action;
    private Person person;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
