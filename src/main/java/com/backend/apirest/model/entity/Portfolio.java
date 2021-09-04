package com.backend.apirest.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(schema = "zemoga_test_db", name = "portfolio")
public class Portfolio implements Serializable {

  private static final long serialVersionUID = -3501295279055998630L;

  @Id
  @Column(name = "idportfolio")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "description")
  private String description;
  @Column(name = "last_names")
  private String lastNames;
  @Column(name = "names")
  private String names;
  @Column(name = "image_url")
  private String imageUrl;
  @Column(name = "experience_summary")
  private String experienceSummary;
  @Column(name = "title")
  private String title;
  @Column(name = "user_id")
  private String userId;
  @Column(name = "twitter_user_id")
  private String twitterUserId;
  @Column(name = "twitter_user_name")
  private String twitterUserName;


}
