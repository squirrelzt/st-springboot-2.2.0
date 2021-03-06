package com.controller;

import com.alibaba.fastjson.JSON;
import com.domain.Person;
import com.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("jpa")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("insert")
    public void insert(@RequestBody Person person) {
        log.info("insert api input parameters: {}", JSON.toJSONString(person));
        personService.insert(person);
    }

    @GetMapping("getById")
    public Person getById(@RequestParam Long id) {
        log.info("getById api input parameters: {}", id);
        return personService.getById(id);
    }

    @GetMapping("listAll")
    public List<Person> listAll() {
        return personService.listPerson();
    }

    @PostMapping("update")
    public void update(@RequestBody Person person) {
        log.info("update api input parameters: {}", JSON.toJSONString(person));
        personService.update(person);
    }

    @PostMapping("delete")
    public void delete(@RequestBody Person person) {
        log.info("delete api input parameters: {}", JSON.toJSONString(person));
        personService.delete(person);
    }

}
