package com.service.services.ServiceDtos;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
@Builder
public class PageResponse {

    List<ServiceProvidersDto> content;
    Integer number;
    Integer size;
    Long totalElements;
    Integer totalPages;
    Boolean last;
}
