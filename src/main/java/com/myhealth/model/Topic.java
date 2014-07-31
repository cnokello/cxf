package com.myhealth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topic")
public class Topic implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private String name;

  private String description;

  private int numItems;

  private int numArticles;

  private int numCampaigns;

  private int numContributions;

  private String expertLevel;

  private String ageGroup;

  public Topic() {
  }

  public Topic(long id, String name, String description, int numItems, int numArticles,
      int numCampaigns, int numContributions, String expertLevel, String ageGroup) {

    this.id = id;
    this.name = name;
    this.description = description;
    this.numItems = numItems;
    this.numArticles = numArticles;
    this.numCampaigns = numCampaigns;
    this.numContributions = numContributions;
    this.expertLevel = expertLevel;
    this.ageGroup = ageGroup;

  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getNumItems() {
    return numItems;
  }

  public void setNumItems(int numItems) {
    this.numItems = numItems;
  }

  public int getNumArticles() {
    return numArticles;
  }

  public void setNumArticles(int numArticles) {
    this.numArticles = numArticles;
  }

  public int getNumCampaigns() {
    return numCampaigns;
  }

  public void setNumCampaigns(int numCampaigns) {
    this.numCampaigns = numCampaigns;
  }

  public int getNumContributions() {
    return numContributions;
  }

  public void setNumContributions(int numContributions) {
    this.numContributions = numContributions;
  }

  public String getExpertLevel() {
    return expertLevel;
  }

  public void setExpertLevel(String expertLevel) {
    this.expertLevel = expertLevel;
  }

  public String getAgeGroup() {
    return ageGroup;
  }

  public void setAgeGroup(String ageGroup) {
    this.ageGroup = ageGroup;
  }

}
