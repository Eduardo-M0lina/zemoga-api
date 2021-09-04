package com.backend.apirest.controller;

import com.backend.apirest.model.entity.Portfolio;
import com.backend.apirest.model.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PortfolioController {

  @Autowired
  private PortfolioService service;

  @GetMapping("/portfolios")
  public List<Portfolio> listPortfolios(){
    return service.findAll();
  }

  @GetMapping("/portfolio/{id}")
  public Portfolio getPortfolio(@PathVariable Integer id){
    return service.findById(id);
  }

  @PostMapping("/portfolio")
  @ResponseStatus(HttpStatus.CREATED)
  public Portfolio create(@RequestBody Portfolio portfolio){
    return service.save(portfolio);
  }

  @PutMapping("/portfolio/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Portfolio update(@RequestBody Portfolio portfolio, @PathVariable Integer id) throws Exception {
    return service.update(portfolio,id);
  }

  @DeleteMapping("/portfolio/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Integer id){
    service.delete(id);
  }


}
