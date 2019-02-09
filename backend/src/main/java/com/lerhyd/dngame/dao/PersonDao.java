package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.News;
import com.lerhyd.dngame.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {

    Person findById(int id);

    boolean existsByNameAndSurnameAndPatronymicAndSex(String name, String surname, String patronymic, boolean sex);

    Person findByNameAndSurnameAndPatronymicAndSex(String name, String surname, String patronymic, boolean sex);

    @Query("select p.criminal from Person p where p.name=:name and p.surname=:surname and p.patronymic=:patr and p.sex=:sex")
    Optional<Boolean> findIfCriminal(@Param("name") String name, @Param("surname") String surname,
                            @Param("patr") String patronymic, @Param("sex") boolean sex);

    @Query("select p from Person p where p.criminal=true order by function('RAND')")
    List<Person> findAllCriminalPeronsInRandomOrder();

    @Query("select p from Person p where p.criminal=false order by function('RAND')")
    List<Person> findAllNotCriminalPeronsInRandomOrder();

    @Query("select p from Person p order by function('RAND')")
    List<Person> findAllPeronsInRandomOrder();

    @Transactional
    @Modifying
    @Query("delete from Person p where p.fake = true")
    void deleteAllByFake();

    @Query("select p from Person p where p.user.id = :userLogin")
    Person findPersonByUser(@Param("userLogin") String userLogin);

    @Query("select p.id from Person p where p.id=:randId and p.criminal=:criminal")
    int findPersonByIdAndCriminal(@Param("randId") int randId, @Param("criminal") boolean isCriminal);

    @Query("select count(p) from Person p where p.criminal=true")
    int cntCriminalPersons();

    @Query("select count(p) from Person p where p.criminal=false ")
    int cntNonCriminalPersons();
}
