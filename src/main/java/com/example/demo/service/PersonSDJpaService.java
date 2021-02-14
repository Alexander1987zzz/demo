package com.example.demo.service;

import model.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import repository.PersonRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonSDJpaService implements PersonService {

    private final PersonRepository personRepository;

    public PersonSDJpaService(PersonRepository personRepository) {
        this.personRepository = personRepository;

    }

    @Override
    public Set<Person> findAll() {
        Set<Person> persons = new HashSet<>();
        personRepository.findAll().forEach(persons::add);
        return (Set<Person>) persons.stream().sorted(findByFullName());
    }

    @Override
    public Person findById(Long aLong) {


        return personRepository.findById(aLong).orElse(null);
    }

    @Override
    public Person save(Person object) {

        return personRepository.save(object);
    }

    @Override
    public void delete(Person object) {

        personRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {

        personRepository.deleteById(aLong);
    }

    @Override
    public Person findByFullName(String fullName) {
        return personRepository.findByFullName(fullName);
    }
}
