package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionDao extends JpaRepository<Region, Integer> {

    Region findById(int id);

    @Query("select r from Region r where r.city is not null order by function('RAND')")
    List<Region> findAllRegionsInRandomOrder();

    @Query("select distinct(r.continent) from Region r where r.continent is not null")
    List<String> findAllRegionsWithContinents();

    @Query("select distinct(r.country) from Region r where r.continent = :continent and r.country is not null")
    List<String> findAllRegionsWithCountriesByContinent(@Param("continent") String continent);

    @Query("select distinct(r.city) from Region r where r.country = :country and r.city is not null")
    List<String> findAllRegionsWithCitiesByCountry(@Param("country") String country);

    @Query("select r.id from Region r where r.city = :city")
    int findRegionIdByCity(@Param("city") String city);

    @Query("select r.id from Region r where r.city = :city and r.country=:country and r.continent=:continent")
    int findRegionId(@Param("city") String city, @Param("country") String country, @Param("continent") String continent);

    @Query("select r.id from Region r where r.city is null and r.country is null and r.continent=:continent")
    int findRegionIdwithoutCountry(@Param("continent") String continent);

    @Query("select r.id from Region r where r.city is null and r.country=:country and r.continent=:continent")
    int findRegionIdwithoutCity(@Param("country") String country, @Param("continent") String continent);
}
