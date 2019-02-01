package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonDao extends JpaRepository<Person, Long> {

    Person findById(long id);

    boolean existsByNameAndSurnameAndPatronymicAndSex(String name, String surname, String patronymic, boolean sex);

    Person findByNameAndSurnameAndPatronymicAndSex(String name, String surname, String patronymic, boolean sex);

    @Query("select p.criminal from Person p where p.name=:name and p.surname=:surname and p.patronymic=:patr and p.sex=:sex")
    boolean checkPersonIfCriminal(@Param("name") String name,@Param("surname") String surname,
                                  @Param("patr") String patronymic,@Param("sex") boolean sex);

    @Transactional
    @Modifying
    @Query("delete from Person p where p.fake = true")
    void deleteAllByFake();
}
