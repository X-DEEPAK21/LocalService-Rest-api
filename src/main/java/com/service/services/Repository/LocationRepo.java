package com.service.services.Repository;

import com.service.services.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepo extends JpaRepository<Location,Long> {
    public Optional<Location> findByStateAndDistrictAndBlockAndVillage(
            String state,
            String district,
            String block,
            String village
    );
}
