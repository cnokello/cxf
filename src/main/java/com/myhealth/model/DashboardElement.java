package com.myhealth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dashboard_element")
public class DashboardElement implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private String label;

  private String url;

  private String description;

  private int enabled;

  public DashboardElement() {
  }

  public DashboardElement(String label, String url, String description, int enabled) {
    this.label = label;
    this.url = url;
    this.description = description;
    this.enabled = enabled;
  }

  public DashboardElement(long id, String label, String url, String description, int enabled) {
    this.id = id;
    this.label = label;
    this.url = url;
    this.description = description;
    this.enabled = enabled;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getEnabled() {
    return enabled;
  }

  public void setEnabled(int enabled) {
    this.enabled = enabled;
  }

}
