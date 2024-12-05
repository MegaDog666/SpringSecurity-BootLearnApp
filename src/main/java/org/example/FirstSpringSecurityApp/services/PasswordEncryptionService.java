package org.example.FirstSpringSecurityApp.services;

import org.example.FirstSpringSecurityApp.models.Person;
import org.example.FirstSpringSecurityApp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordEncryptionService {

    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PasswordEncryptionService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void encryptPasswords() {
        List<Person> persons = peopleRepository.findAll();
        for (Person person : persons) {
            String encodedPassword = passwordEncoder.encode(person.getPassword());
            person.setPassword(encodedPassword);
            peopleRepository.save(person);
        }
    }
}
