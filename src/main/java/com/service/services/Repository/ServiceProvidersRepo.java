package com.service.services.Repository;

import com.service.services.Entity.ServiceProviders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceProvidersRepo extends JpaRepository<ServiceProviders,Long> {

    Optional<ServiceProviders> findByPhone(String phone);
}
