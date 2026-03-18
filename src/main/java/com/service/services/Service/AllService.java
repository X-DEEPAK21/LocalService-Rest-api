package com.service.services.Service;

import com.service.services.Entity.Location;
import com.service.services.Entity.ServiceProviders;
import com.service.services.Mapping.UniversalMapping;
import com.service.services.Repository.ServiceProvidersRepo;
import com.service.services.ServiceDtos.PageResponse;
import com.service.services.ServiceDtos.ServiceProvidersDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AllService {
    @Autowired
    ServiceProvidersRepo serviceProvidersRepo;
    @Autowired
    ModelMapper modelMapper;  //always need no args Constructor
    @Autowired
    UniversalMapping universalMapping;

    //Test only
     public Page<ServiceProviders>  checkRepositoryMethods(){
         int page=0;
         int size=10;
         Pageable pageable = PageRequest.of(page, size);
       Page<ServiceProviders> serviceProviders=
            serviceProvidersRepo.findByCategories_NameAndLocation_State("Electrician","Odisha",pageable);
         return serviceProviders;
     }
     //Test Only
    public Page<ServiceProviders>  checkRepositoryMethods2(){
        int page=0;
        int size=10;
        Pageable pageable = PageRequest.of(page, size);
        Page<ServiceProviders> serviceProviders=
                serviceProvidersRepo.findByCategories_NameAndLocation_StateAndLocation_DistrictAndLocation_BlockAndLocation_Village(
                        "Painter","Odisha","Keonjhar","Anandapur","Kodapada",pageable
                );
        return serviceProviders;
    }

    //findBy Categories name only
    @Transactional
    public PageResponse findByCategoriesName(String category, int page, int size){
         log.info("try to find serviceProviders by category name {}",category);
         Pageable pageable=PageRequest.of(page,size);
       Page<ServiceProviders> serviceProviders= serviceProvidersRepo.findByCategories_Name(category,pageable);
       log.info("find successful Time delegates to other class for mapping");
       PageResponse pageResponse= universalMapping.getMapped(serviceProviders);
       log.info("map successful lets return response in the response Entity");

       return pageResponse;


    }





}
