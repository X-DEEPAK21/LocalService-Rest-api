package com.service.services.Controller;


import com.service.services.Entity.ServiceProviders;
import com.service.services.Service.AllService;
import com.service.services.ServiceDtos.PageResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/location-get")
public class ServiceController {
    @Autowired
    AllService allService;

    @GetMapping("/get-by-category")
     public ResponseEntity<PageResponse> getServiceProvidersByCategoryName(@RequestParam String category,@RequestParam int page,@RequestParam int size){
        log.info("request reached at controller and forwarded to the all service method");
        PageResponse pageResponse= allService.findByCategoriesName(category,page,size);
        log.info("response return from the all service return the the frontend");
         return ResponseEntity.status(HttpStatus.OK).body(pageResponse);
     }

     @GetMapping("/get-by-location/state/{state}")
     public ResponseEntity<PageResponse> getServiceProvidersByLocationState(@PathVariable String state,@RequestParam int page,@RequestParam int size){
        log.info("request reached at the controller and forwarded to the allService method");
        PageResponse pageResponse=allService.findByStateName(state,page,size);
        log.info("response generated lets return  to the client");
        return ResponseEntity.status(HttpStatus.OK).body(pageResponse);
     }

     @GetMapping("/get-by-location/{state}/{district}")
     public ResponseEntity<?> getServiceProviderByLocationStateAndDistrict(
             @PathVariable String state,
             @PathVariable String district,
             @RequestParam int page,@RequestParam int size){
        log.info("request reached at controller delegates the request to the AllService ");
        PageResponse pageResponse= allService.findByStateAndDistrictName(state,district,size,page);
        log.info("requested response generated successfully lets return to the client");
        return ResponseEntity.status(HttpStatus.OK).body(pageResponse);
     }

    @GetMapping("/get-by-location/{state}/{district}/{block}")
     public ResponseEntity<?> getServiceProvidersByLocationStateAndDistrictAndBlock(
            @PathVariable String state,@PathVariable String district,@PathVariable String block,
            @RequestParam int page,@RequestParam int size){
        log.info("request reached at the controller move forwards to all service");
        PageResponse pageResponse=allService.findByStateAndDistrictAndBlockName(state,district,block,size,page);
        log.info("requested response generated successfully lets return to the client");
        return ResponseEntity.status(HttpStatus.OK).body(pageResponse);
    }

    @GetMapping("/get-by-location/{state}/{district}/{block}/{village}")
    public ResponseEntity<?> getServiceProvidersByLocationStateAndDistrictAndBlock(
            @PathVariable String state,@PathVariable String district,@PathVariable String block,@PathVariable String village,
            @RequestParam int page,@RequestParam int size){
      PageResponse pageResponse= allService.findByStateAndDistrictAndBlockAndVillageName(state, district, block, village, page, size);
        log.info("requested response generated successfully lets return to the client");
        return ResponseEntity.status(HttpStatus.OK).body(pageResponse);

    }




}
