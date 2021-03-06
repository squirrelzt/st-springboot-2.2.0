package com.service;

import com.domain.Person;

import java.util.List;

public interface PersonService {

    void insert(Person person);

    Person getById(long id);

    List<Person> listPerson();

    void update(Person person);

    void delete(Person person);
}
