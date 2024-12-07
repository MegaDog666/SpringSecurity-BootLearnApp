package org.example.FirstSpringSecurityApp.util;

import org.example.FirstSpringSecurityApp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.example.FirstSpringSecurityApp.models.Person;

@Component
public class PersonValidator implements Validator {

    private final PersonService personService;

    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if (personService.findByUsername(person.getUsername()).isPresent())
            errors.rejectValue("username", "", "Человек с таким именем пользователя уже существует");

    }
}
