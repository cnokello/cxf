package com.myhealth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private long topicId;

  private String itemType;

  private String title;

  private String shortDescription;

  private String longDescription;

  private String content;

  private String expertLevel;

  private String ageGroup;

  private String hashTags;

  private long createdOn;

  public Item() {
  }

  public Item(long id, long topicId, String title, String shortDescription, String longDescription,
      String content, String expertLevel, String ageGroup, String hashTags) {
    this.id = id;
    this.topicId = topicId;
    this.title = title;
    this.shortDescription = shortDescription;
    this.longDescription = longDescription;
    this.content = content;
    this.expertLevel = expertLevel;
    this.ageGroup = ageGroup;
    this.hashTags = hashTags;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getTopicId() {
    return topicId;
  }

  public void setTopicId(long topicId) {
    this.topicId = topicId;
  }

  public String getItemType() {
    return itemType;
  }

  public void setItemType(String itemType) {
    this.itemType = itemType;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getLongDescription() {
    return longDescription;
  }

  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
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

  public String getHashTags() {
    return hashTags;
  }

  public void setHashTags(String hashTags) {
    this.hashTags = hashTags;
  }

  public long getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(long createdOn) {
    this.createdOn = createdOn;
  }
}
