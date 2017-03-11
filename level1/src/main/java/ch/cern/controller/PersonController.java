package ch.cern.controller;

import ch.cern.domain.Person;
import ch.cern.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
  @Autowired
  private PersonRepository personRepository;

  @RequestMapping(path = "/persons/create", method = RequestMethod.POST)
  public Person createPerson(@RequestBody Person person) {
    return personRepository.save(person);
  }

  @RequestMapping(path = "/persons/read", method = RequestMethod.POST)
  public List<Person> getPersons() {
    return (List<Person>) personRepository.findAll();
  }

  @RequestMapping(path = "/persons/update", method = RequestMethod.POST)
  public Person updatePerson(@RequestBody Person person) {
    return personRepository.save(person);
  }

  @RequestMapping(path = "/persons/delete", method = RequestMethod.POST)
  public void deletePerson(@RequestBody Person person) {
    personRepository.delete(person);
  }

}
