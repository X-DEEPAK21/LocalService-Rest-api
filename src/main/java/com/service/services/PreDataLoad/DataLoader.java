package com.service.services.PreDataLoad;

import com.service.services.Entity.Category;
import com.service.services.Repository.CategoryRepo;
import com.service.services.Repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public void run(String... args) throws Exception {
     if(categoryRepo.count()==0){
         categoryRepo.save(new Category("Plumber"));
         categoryRepo.save(new Category("Electrician"));
         categoryRepo.save(new Category("Painter"));
         categoryRepo.save(new Category("AC Technician"));
         categoryRepo.save(new Category("Mechanic"));
         categoryRepo.save(new Category("House Cleaner"));
         categoryRepo.save(new Category("Gardener"));
         categoryRepo.save(new Category("CCTV Technician"));

     }
    }

    /*
    ('Plumber'),
('Electrician'),
('Carpenter'),
('Painter'),
('AC Technician'),
('Mechanic'),
('Mason'),
('Welder'),
('House Cleaner'),
('Pest Control'),
('Gardener'),
('CCTV Technician');
     */
}
