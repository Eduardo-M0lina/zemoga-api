package com.backend.apirest.model.services;

import com.backend.apirest.model.entity.Portfolio;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PortfolioService {

  public List<Portfolio> findAll();

  public ResponseEntity<?> findById(Integer id);

  public ResponseEntity<?> save(Portfolio portfolio);

  public ResponseEntity<?> update(Portfolio portfolio, Integer id);

  public ResponseEntity<?> delete(Integer id);

}
