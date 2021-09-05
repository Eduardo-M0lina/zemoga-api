package com.backend.apirest.model.handlers;

import com.backend.apirest.model.dao.PortfolioDao;
import com.backend.apirest.model.entity.Portfolio;
import com.backend.apirest.model.services.PortfolioService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PortfolioHandler implements PortfolioService {

  @Autowired
  private PortfolioDao portfolioDao;

  @Override
  @Transactional(readOnly = true)
  public List<Portfolio> findAll() {
    return (List<Portfolio>) portfolioDao.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public ResponseEntity<?> findById(Integer id) {
    Portfolio portfolio = null;
    Map<String, Object> response = new HashMap<>();
    try {
      portfolio = portfolioDao.findById(id).orElse(null);
    } catch (DataAccessException e) {
      response.put("message", "Error to execute query in db");
      response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    if (Objects.isNull(portfolio)) {
      response.put("message", "Porfolio with ID:".concat(id.toString().concat(" not found")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Portfolio>(portfolio, HttpStatus.OK);
  }

  @Override
  @Transactional
  public ResponseEntity<?> save(Portfolio portfolio) {
    Portfolio portfolioNew = null;
    Map<String, Object> response = new HashMap<>();
    try {
      portfolioNew = portfolioDao.save(portfolio);
    } catch (DataAccessException e) {
      response.put("message", "Error to execute insert in db");
      response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    response.put("message", "Portfolio created successfully!");
    response.put("portfolio", portfolioNew);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }

  @Override
  @Transactional
  public ResponseEntity<?> update(Portfolio portfolio, Integer id) {
    Map<String, Object> response = new HashMap<>();
    Portfolio portfolioUpdated = null;
    Portfolio portfolioOld = portfolioDao.findById(id).orElse(null);
    if (Objects.isNull(portfolioOld)) {
      response.put("message", "Porfolio with ID:".concat(id.toString().concat(" not found")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    try {
      portfolioOld.setNames(portfolio.getNames());
      portfolioOld.setLastNames(portfolio.getLastNames());
      portfolioOld.setDescription(portfolio.getDescription());
      portfolioOld.setImageUrl(portfolio.getImageUrl());
      portfolioOld.setTitle(portfolio.getTitle());
      portfolioOld.setExperienceSummary(portfolio.getExperienceSummary());
      portfolioOld.setTwitterUserName(portfolio.getTwitterUserName());
      portfolioOld.setTwitterUserId(portfolio.getTwitterUserId());
      portfolioUpdated = portfolioDao.save(portfolioOld);
    } catch (DataAccessException e) {
      response.put("message", "Error to execute update in db");
      response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    response.put("message", "Portfolio updated successfully!");
    response.put("portfolio", portfolioUpdated);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<?> delete(Integer id) {
    Map<String, Object> response = new HashMap<>();
    try {
      portfolioDao.deleteById(id);
    } catch (DataAccessException e) {
      response.put("message", "Error to execute update in db");
      response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    response.put("message", "Portfolio deleted successfully!");
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
  }
}
