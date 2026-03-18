package com.service.services.ServiceDtos;

import com.service.services.Entity.Category;
import com.service.services.Entity.Gender;
import com.service.services.Entity.Location;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProvidersDto {
    private String full_name;
    private String phone;
    private String email;
    private Gender gender;
    private String profile_url;
    private List<String> categoriesManualSet;


    private Integer experience;
    private String workDescription;
    private String state;
    private String district;
    private String block;
    private String village;
    private boolean isActive = true;
}
