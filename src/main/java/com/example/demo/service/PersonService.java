package com.example.demo.service;

import model.Gender;
import model.Person;

import java.time.LocalDate;

public interface PersonService extends CrudService<Person, Long>{

    Person findByFullName(String fullName);

    Person findByBirthDate(LocalDate birthDate);

    Person findByGender(Gender gender);

    }
