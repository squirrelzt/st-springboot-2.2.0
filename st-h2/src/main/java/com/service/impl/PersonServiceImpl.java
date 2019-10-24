package com.service.impl;

import com.dao.PersonRepository;
import com.domain.Person;
import com.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void insert(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person getById(long id) {
        return personRepository.getOne(id);
    }

    @Override
    public List<Person> listPerson() {
        return personRepository.findAll();
    }

    @Override
    public void update(Person person) {
        personRepository.save(person);
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }

    @Override
    public List<Person> findPersonByNameAndAge(String name, int age) {
        return personRepository.findPersonByNameAndAge(name, age);
    }

    @Override
    public List<Person> findPersonByAge(int age) {
        return personRepository.findPersonByAge(age);
    }

    @Override
    public List<Person> selectByPerson(Person person) {
        return personRepository.selectByPerson(person);
    }
}
