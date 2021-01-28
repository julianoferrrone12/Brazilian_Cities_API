package com.github.julianof.citiesapi.repository;

import com.github.julianof.citiesapi.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Long> {
    
    
    @Query(nativeQuery = true,
           value= "select ((select lat_lon from cidade where id = ?1) <@> (select lat_lon from cidade where id=?2)) as distance")
    Double distanceByPoints(Long city1,
                            Long city2);
    
    @Query(nativeQuery = true,
            value= "select earth_distance( ll_to_earth(?1,?2),  ll_to_earth(?3,?4) as distance")
    Double distanceByCube(double x,
                        double y,
                        double x1,
                        double y1);
}
