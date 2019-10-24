package com.dao;

import com.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "select id, age, gender, name, create_time, create_date from person where name = ?1 and age = ?2", nativeQuery = true)
    List<Person> findPersonByNameAndAge(String name, int age);

    @Query(value = "select id, age, gender, name, create_time, create_date from person where age = :age", nativeQuery = true)
    List<Person> findPersonByAge(@Param("age") int age);

    @Query(value = "select id, age, gender, name, create_time, create_date from person where name = :#{#person.name} AND age = :#{#person.age}", nativeQuery = true)
    List<Person> selectByPerson(@Param("person") Person person);
}
