package ch.cern.controller;

import ch.cern.repository.PersonRepository;
import ch.cern.domain.Person;
import ch.cern.request.PersonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
  @Autowired
  private PersonRepository personRepository;

  @RequestMapping(path = "/persons", method = RequestMethod.POST)
  public List<Person> personActions(@RequestBody PersonRequest personRequest) {

    if (personRequest == null || personRequest.getAction() == null) {
      return null;
    }

    String action = personRequest.getAction();

    if (action.equals("READ")){
      return (List<Person>) personRepository.findAll();
    } else if (action.equals("CREATE") || action.equals("UPDATE")){
      personRepository.save(personRequest.getPerson());
    } else if (action.equals("DELETE")){
      personRepository.delete(personRequest.getPerson());
    }

    return null;
  }
}
