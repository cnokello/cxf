package com.myhealth.app;

import org.springframework.stereotype.Service;

import com.myhealth.model.User;

/**
 * The update model
 * 
 * @author nelson.okello
 * 
 */
@Service(value = "persistenceService")
public class PersistenceService {

  public boolean createUser(User u) {
    return true;
  }

}
