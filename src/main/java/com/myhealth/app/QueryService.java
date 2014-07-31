package com.myhealth.app;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhealth.dao.MyHealthDAO;
import com.myhealth.model.DashboardElement;
import com.myhealth.model.Item;
import com.myhealth.model.Topic;
import com.myhealth.model.User;

/**
 * The query model
 * 
 * @author nelson.okello
 * 
 */
@Service(value = "queryService")
public class QueryService {

  private @Autowired
  MyHealthDAO myHealthDAO;

  /**
   * Performs authentication
   * 
   * @return Returns the logged on user
   */
  public User login(final String username, final String password, final String imei) {
    User u = null;
    try {
      u = myHealthDAO.getUserByUsername(username);

    } catch (Exception e) {
    }

    return u;
  }

  /**
   * Retrieves dashboard elements
   * 
   * @return Returns dashboard elements
   */
  public Set<DashboardElement> dashboard() {
    Set<DashboardElement> ds = new HashSet<DashboardElement>();
    try {
      ds = myHealthDAO.getDashboard();
    } catch (Exception e) {
    }

    return ds;
  }

  /**
   * Retrieves topics
   * 
   * @return Returns a list of topics
   */
  public Set<Topic> topics() {
    Set<Topic> topics = new HashSet<Topic>();
    try {
      topics = myHealthDAO.getTopics();
    } catch (Exception e) {
    }

    return topics;
  }

  /**
   * Retrieves items
   * 
   * @param itemType
   *          Type of items to retrieve
   * @param topicId
   *          Topics whose items are to be retrieved
   * @param page
   *          Page to retrieve
   * @param offset
   *          The number of items per page
   * @return Returns items
   */
  public Set<Item> items(String itemType, long topicId, int page, int offset) {
    Set<Item> items = new HashSet<Item>();
    try {
      items = myHealthDAO.getItems(topicId, itemType);
    } catch (Exception e) {
    }

    return items;
  }
}
