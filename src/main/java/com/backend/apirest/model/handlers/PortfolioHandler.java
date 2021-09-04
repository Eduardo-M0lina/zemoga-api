package com.backend.apirest.model.handlers;

import com.backend.apirest.model.dao.PortfolioDao;
import com.backend.apirest.model.entity.Portfolio;
import com.backend.apirest.model.services.PortfolioService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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
  public Portfolio findById(Integer id) {
    return portfolioDao.findById(id).orElse(null);
  }

  @Override
  @Transactional
  public Portfolio save(Portfolio portfolio) {
    return portfolioDao.save(portfolio);
  }

  @Override
  @Transactional
  public Portfolio update(Portfolio portfolio, Integer id) throws Exception{
    Portfolio portfolioOld = portfolioDao.findById(id).get();
    if(Objects.isNull(portfolioOld))
      throw new NotFoundException("Portfolio not found");

    portfolioOld.setNames(portfolio.getNames());
    portfolioOld.setLastNames(portfolio.getLastNames());
    portfolioOld.setDescription(portfolio.getDescription());
    portfolioOld.setImageUrl(portfolio.getImageUrl());
    portfolioOld.setTitle(portfolio.getTitle());
    portfolioOld.setExperienceSummary(portfolio.getExperienceSummary());
    portfolioOld.setTwitterUserName(portfolio.getTwitterUserName());
    portfolioOld.setTwitterUserId(portfolio.getTwitterUserId());

    return portfolioDao.save(portfolioOld);
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    portfolioDao.deleteById(id);
  }
}
