package com.service.services.Mapping;

import com.service.services.Entity.Location;
import com.service.services.Entity.ServiceProviders;
import com.service.services.ServiceDtos.PageResponse;
import com.service.services.ServiceDtos.ServiceProvidersDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UniversalMapping {
    @Autowired
    ModelMapper modelMapper;
    public PageResponse getMapped(Page<ServiceProviders> serviceProvidersPage){
        List<ServiceProvidersDto> serviceProvidersDtos=serviceProvidersPage.getContent().stream()
                .map((x)->{
                    Location location=x.getLocation();
                    List<String> categoryList= x.getCategories().stream().map(y->y.getName())
                            .collect(Collectors.toList());
                    ServiceProvidersDto dto =modelMapper.map(x, ServiceProvidersDto.class);
                    dto.setCategoriesManualSet(categoryList);
                    dto.setState(location.getState());
                    dto.setDistrict(location.getDistrict());
                    dto.setBlock(location.getBlock());
                    dto.setVillage(location.getVillage());
                    return dto;
                }).collect(Collectors.toList());

        PageResponse pageResponse=PageResponse.builder()
                .content(serviceProvidersDtos)
                .number(serviceProvidersPage.getNumber())
                .size(serviceProvidersPage.getSize())
                .totalElements(serviceProvidersPage.getTotalElements())
                .totalPages(serviceProvidersPage.getTotalPages())
                .last(serviceProvidersPage.isLast()).build();

           return pageResponse;
    }
}
