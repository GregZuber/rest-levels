package ch.cern.controller;

import ch.cern.domain.Person;
import ch.cern.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
  @Autowired
  private PersonRepository personRepository;

  @ResponseStatus(HttpStatus.CREATED)
  @RequestMapping(method = RequestMethod.POST)
  public void createPerson(@RequestBody Person person) {
    personRepository.save(person);
  }

  @RequestMapping
  public List<Person> getPersons() {
    return (List<Person>) personRepository.findAll();
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public Person getPerson(@PathVariable Long id) {
    return personRepository.findOne(id);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
  public void updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
    Person person = personRepository.findOne(id);
    person.update(updatedPerson);
    personRepository.save(person);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
  public void deletePerson(@PathVariable Long id) {
    personRepository.delete(id);
  }

}
