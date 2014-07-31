package com.myhealth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "health_user")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private String surname;

  private String otherNames;

  private String username;

  private String password;

  private String password1;

  private String email;

  private String mobile;

  private String imei;

  private String socialNetworkToken;

  private String socialNetworkSecret;

  private String socialNetwork;

  public User() {
  }

  public User(String surname, String otherNames, String username, String password,
      String password1, String email, String mobile, String imei, String socialNetworkToken,
      String socialNetworkSecret, String socialNetwork) {

    this.id = new java.util.Date().getTime();
    this.surname = surname;
    this.otherNames = otherNames;
    this.password = password;
    this.password1 = password1;
    this.email = email;
    this.mobile = mobile;
    this.imei = imei;
    this.socialNetworkToken = socialNetworkToken;
    this.socialNetworkSecret = socialNetworkSecret;
    this.socialNetwork = socialNetwork;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getOtherNames() {
    return otherNames;
  }

  public void setOtherNames(String otherNames) {
    this.otherNames = otherNames;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword1() {
    return password1;
  }

  public void setPassword1(String password1) {
    this.password1 = password1;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getImei() {
    return imei;
  }

  public void setImei(String imei) {
    this.imei = imei;
  }

  public String getSocialNetworkToken() {
    return socialNetworkToken;
  }

  public void setSocialNetworkToken(String socialNetworkToken) {
    this.socialNetworkToken = socialNetworkToken;
  }

  public String getSocialNetworkSecret() {
    return socialNetworkSecret;
  }

  public void setSocialNetworkSecret(String socialNetworkSecret) {
    this.socialNetworkSecret = socialNetworkSecret;
  }

  public String getSocialNetwork() {
    return socialNetwork;
  }

  public void setSocialNetwork(String socialNetwork) {
    this.socialNetwork = socialNetwork;
  }

}
