package com.backend.apirest.model.services;

import com.backend.apirest.model.entity.Portfolio;

import java.util.List;

public interface PortfolioService {

  public List<Portfolio> findAll();

  public Portfolio findById(Integer id);

  public Portfolio save(Portfolio portfolio);

  public Portfolio update(Portfolio portfolio, Integer id) throws Exception;
  public void delete(Integer id);

}
