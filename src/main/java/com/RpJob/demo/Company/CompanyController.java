package com.RpJob.demo.Company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/company")
public class CompanyController {


    private CompanyService service;


    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){

        boolean isAdded = service.addCompany(company);

                if(!isAdded){
                    return new ResponseEntity<String>("There is an error Company Not Added" ,
                            HttpStatus.BAD_REQUEST);
                }

        return new ResponseEntity<String>("Company  Added" ,
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(){
       return new ResponseEntity<>(service.getAllCompany() , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable int id , @RequestBody Company company){
          if(service.updateJob(id , company)){
              return new ResponseEntity<>("Updated successfully " , HttpStatus.OK);
          }

        return new ResponseEntity<>("there is some thing wrong while update  " , HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getComapnyById(@PathVariable int id) {
        Company c = service.getById(id);

        if (c == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity<>(c, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable int id){
        boolean isDeleted = service.deleteCompany(id);

        if(!isDeleted){
            return new ResponseEntity<>("No company foound" , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Deleted" , HttpStatus.FOUND);
    }
}
