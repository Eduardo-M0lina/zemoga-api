package com.backend.apirest.controller;

import com.backend.apirest.model.entity.Portfolio;
import com.backend.apirest.model.services.PortfolioService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(PortfolioController.class)
public class PortfolioControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @InjectMocks
  PortfolioController portfolioController;

  @Mock
  private PortfolioService service;

  Portfolio portfolio;

  final int USER_ID = 2;

  @BeforeEach
  void setUp()throws Exception{
    MockitoAnnotations.initMocks(this);

    portfolio = new Portfolio();
    portfolio.setId(USER_ID);
    portfolio.setDescription("Any Description");
    portfolio.setLastNames("Salazar Ferrer");
    portfolio.setNames("Rafael José");
    portfolio.setImageUrl("https://pbs.twimg.com/profile_images/1414439092373254147/JdS8yLGI_200x200.jpg");
    portfolio.setExperienceSummary("");
    portfolio.setTitle("Backend Dev");
    portfolio.setTwitterUserId("adidas");
  }

  @Test
  public void listPortfolios() throws Exception{


  }

  @Test
  public void getPortfolio() throws Exception {
    when(service.findById(anyInt())).thenReturn(null);


  }

  @Test
  public void create() {
  }

  @Test
  public void update() {
  }

  @Test
  public void delete() {
  }
}