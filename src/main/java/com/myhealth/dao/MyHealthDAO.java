package com.myhealth.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhealth.model.DashboardElement;
import com.myhealth.model.Item;
import com.myhealth.model.Topic;
import com.myhealth.model.User;

/**
 * The query class for the UI
 * 
 * @author nelson.okello
 * 
 */
@Service(value = "myHealthDAO")
public class MyHealthDAO {

  private @Autowired
  SessionFactory sessionFactory;

  /**
   * Retrieves user by username
   * 
   * @param username
   *          Specified username
   * @return Returns the matched user
   * @throws Exception
   */
  public User getUserByUsername(final String username) throws Exception {
    Session session = null;
    User u = new User();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM User WHERE username = :username")
          .setString("username", username).setFetchSize(1);
      List l = q.list();
      if (l != null && l.size() > 0) {
        u = (User) l.get(0);
      }

    } catch (Exception e) {

    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return u;
  }

  /**
   * Retrieves dashboard elements
   * 
   * @return Returns dashboard elements
   * @throws Exception
   */
  public Set<DashboardElement> getDashboard() throws Exception {
    Session session = null;
    Set<DashboardElement> d = new HashSet<DashboardElement>();
    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("From DashboardElement");
      d.addAll(q.list());

    } catch (Exception e) {

    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return d;
  }

  /**
   * Retrieves topics
   * 
   * @return Returns a set of topics
   * @throws Exception
   */
  public Set<Topic> getTopics() throws Exception {
    Session session = null;
    Set<Topic> topics = new HashSet<Topic>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Topic");
      topics.addAll(q.list());

    } catch (Exception e) {

    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return topics;
  }

  /**
   * Retrieves items for the specified topic
   * 
   * @param topicId
   *          Topic whose items are to be retrieved
   * @return Returns items under the specified topic
   * @throws Exception
   */
  public Set<Item> getItems(final long topicId) throws Exception {
    Session session = null;
    Set<Item> items = new HashSet<Item>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Item WHERE topicId = :topicId").setLong("topicId",
          topicId);
      items.addAll(q.list());

    } catch (Exception e) {

    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return items;
  }

  /**
   * Retrieves items of a specified type
   * 
   * @param itemType
   *          The type of items to retrieve
   * @return Returns items of the specified type
   * @throws Exception
   */
  public Set<Item> getItems(final String itemType) throws Exception {
    Session session = null;
    Set<Item> items = new HashSet<Item>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Item WHERE itemType = :itemType").setString("itemType",
          itemType);
      items.addAll(q.list());

    } catch (Exception e) {

    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return items;

  }

  /**
   * Retrieves items for a specified topic and type
   * 
   * @param topicId
   *          The topic whose items are to be retrieved
   * @param itemType
   *          The type of items to retrieve
   * @return Returns items with the specified topic and of the specified type
   * @throws Exception
   */
  public Set<Item> getItems(final long topicId, final String itemType) throws Exception {
    Session session = null;
    Set<Item> items = new HashSet<Item>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Item WHERE topicId = :topicId AND itemType = :itemType")
          .setLong("topicId", topicId).setString("itemType", itemType);
      items.addAll(q.list());

    } catch (Exception e) {

    } finally {
      if (session != null) {
        session.close();
      }
    }

    return items;
  }
}
