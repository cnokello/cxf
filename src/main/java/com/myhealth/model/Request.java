package com.myhealth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request")
public class Request implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private String requestType;

  private long topicId;

  private String description;

  private String hashTags;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getRequestType() {
    return requestType;
  }

  public void setRequestType(String requestType) {
    this.requestType = requestType;
  }

  public long getTopicId() {
    return topicId;
  }

  public void setTopicId(long topicId) {
    this.topicId = topicId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getHashTags() {
    return hashTags;
  }

  public void setHashTags(String hashTags) {
    this.hashTags = hashTags;
  }

}
