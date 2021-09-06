package com.backend.apirest.controller;

import com.backend.apirest.model.entity.Portfolio;
import com.backend.apirest.model.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PortfolioController {

  @Autowired
  private PortfolioService service;

  @GetMapping("/portfolio")
  public List<Portfolio> listPortfolios(){
    return service.findAll();
  }

  @GetMapping("/portfolio/{id}")
  public ResponseEntity<?> getPortfolio(@PathVariable Integer id){
    return service.findById(id);
  }

  @PostMapping("/portfolio")
  public ResponseEntity<?> create(@RequestBody Portfolio portfolio){
    return service.save(portfolio);
  }

  @PutMapping("/portfolio/{id}")
  public ResponseEntity<?> update(@RequestBody Portfolio portfolio, @PathVariable Integer id) throws Exception {
    return service.update(portfolio,id);
  }

  @DeleteMapping("/portfolio/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id){
    return service.delete(id);
  }


}
