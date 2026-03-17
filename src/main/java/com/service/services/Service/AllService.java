package com.service.services.Service;

import com.service.services.Entity.ServiceProviders;
import com.service.services.Repository.ServiceProvidersRepo;
import com.service.services.ServiceDtos.PageResponse;
import com.service.services.ServiceDtos.ServiceProvidersDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Collectors;

@Service
public class AllService {
    @Autowired
    ServiceProvidersRepo serviceProvidersRepo;
    @Autowired
    ModelMapper modelMapper;

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
    public PageResponse findByCategoriesName(String category, int page,int size){
         Pageable pageable=PageRequest.of(page,size);
       Page<ServiceProviders> serviceProviders= serviceProvidersRepo.findByCategories_Name(category,pageable);
      return PageResponse.builder().content(
              serviceProviders.getContent().stream().map((x)->{
          return this.modelMapper.map(x, ServiceProvidersDto.class);
       }).collect(Collectors.toList()))
              .number(serviceProviders.getNumber())
              .size(serviceProviders.getSize())
              .totalElements(serviceProviders.getNumberOfElements())
              .totalPages(serviceProviders.getTotalPages())
              .last(serviceProviders.isLast()).build();
    }



}
