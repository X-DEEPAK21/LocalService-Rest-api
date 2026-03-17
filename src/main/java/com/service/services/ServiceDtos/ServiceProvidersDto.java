package com.service.services.ServiceDtos;

import com.service.services.Entity.Gender;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class ServiceProvidersDto {
    private String full_name;
    private String phone;
    private String email;
    private Gender gender;
    private String profile_url;
    private Set<String> categories;
    ////

    private Integer experience;
    private String workDescription;
    private List<String> location;
    private boolean isActive = true;
}
