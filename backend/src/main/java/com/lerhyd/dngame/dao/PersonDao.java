package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<Person, Long> {

    Person findById(long id);
    boolean existsByNameAndSurnameAndPatronymicAndSex(String name, String surname, String patronymic, boolean sex);
    Person findByNameAndSurnameAndPatronymicAndSex(String name, String surname, String patronymic, boolean sex);
}
