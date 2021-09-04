package com.backend.apirest.model.dao;

import com.backend.apirest.model.entity.Portfolio;
import org.springframework.data.repository.CrudRepository;

public interface PortfolioDao extends CrudRepository<Portfolio, Integer> {
}
