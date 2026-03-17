package com.service.services.ServiceDtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageResponse {

    List<ServiceProvidersDto> content;
    Integer number;
    Integer size;
    Integer totalElements;
    Integer totalPages;
    Boolean last;
}
