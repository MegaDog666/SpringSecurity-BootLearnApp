package org.example.FirstSpringSecurityApp.services;

import org.example.FirstSpringSecurityApp.models.Person;
import org.example.FirstSpringSecurityApp.repositories.PeopleRepository;
import org.example.FirstSpringSecurityApp.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUsername(username);

        if (person.isEmpty())
            throw new UsernameNotFoundException("User not found");

        System.out.println("Found user: " + person.get().getUsername());
        System.out.println("Stored password: " + person.get().getPassword());

        return new PersonDetails(person.get());
    }
}