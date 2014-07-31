package com.myhealth.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.myhealth.model.DashboardElement;
import com.myhealth.model.Item;
import com.myhealth.model.Topic;
import com.myhealth.model.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Web service endpoints
 * 
 * @author nelson.okello
 * 
 */
@Path("/")
public class MyHealthService {

  private @Autowired
  QueryService query;

  private @Autowired
  PersistenceService persistenceService;

  /**
   * Performs authentication
   * 
   * @param username
   *          Username to authenticate
   * @param password
   *          Password to authenticate
   * @param imei
   *          IMEI to authenticate
   * @return
   */
  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Path("/login")
  @GET
  public Response login(@QueryParam("username") final String username,
      @QueryParam("password") final String password, @QueryParam("imei") final String imei,
      @QueryParam("format") final String format, @QueryParam("callback") final String callback) {
    Map<String, Object> resp = new HashMap<String, Object>();

    System.out.println("Authentication request received\n\n");

    resp.put("code", 200);
    resp.put("message", "Request processed successfully");
    resp.put("user", query.login(username, password, imei));

    // Handle XML and Json formats
    // If callback is specified
    Response response = null;
    if (format != null && format.equals("xml")) {
      XStream xStream = new XStream(new DomDriver());
      xStream.alias("login", java.util.Map.class);
      if (callback != null) {
        response = Response.status(Status.OK).type("application/x-javascript")
            .entity(xStream.toXML(resp)).build();
      } else {
        response = Response.status(Status.OK).type("application/xml").entity(xStream.toXML(resp))
            .build();
      }

    } else {
      if (callback != null) {
        response = Response.status(Status.OK).type("application/x-javascript")
            .entity(new Gson().toJson(resp)).build();
      } else {
        response = Response.status(Status.OK).type("application/json")
            .entity(new Gson().toJson(resp)).build();
      }
    }

    return response;
  }

  /**
   * Creates a new user account
   * 
   * @param username
   * @return
   */
  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/createAccount")
  @POST
  public Response createAccount(@FormParam("username") final String username,
      @FormParam("otherNames") final String otherNames, @FormParam("email") final String email,
      @FormParam("mobile") final String mobile, @FormParam("imei") final String imei,
      @FormParam("surname") final String surname, @FormParam("password") final String password,
      @FormParam("password1") final String password1,
      @FormParam("socialNetworkToken") final String socialNetworkToken,
      @FormParam("socialNetworkSecret") final String socialNetworkSecret,
      @FormParam("socialNetwork") final String socialNetwork,
      @QueryParam("format") final String format, @QueryParam("callback") final String callback) {

    System.out.println("Account creation request received\n\n");

    User u = new User(surname, otherNames, username, password, password1, email, mobile, imei,
        socialNetworkToken, socialNetworkSecret, socialNetwork);

    // TODO: Call validation service here

    // TODO: Call persistence service here
    Map<String, Object> resp = new HashMap<String, Object>();
    resp.put("userId", u.getId());
    if (persistenceService.createUser(u) == true) {
      resp.put("code", 200);
      resp.put("message", "User creation successful");
    } else {
      resp.put("code", 201);
      resp.put("message", "User creation failed");
    }

    Response response = null;
    if (format != null && format.equals("xml")) {
      XStream xStream = new XStream(new DomDriver());
      xStream.alias("account", java.util.Map.class);

      if (callback != null) {
        response = Response.status(Status.OK).type("application/x-javascript")
            .entity(xStream.toXML(resp)).build();
      } else {
        response = Response.status(Status.OK).type("application/xml").entity(xStream.toXML(resp))
            .build();
      }

    } else {
      if (callback != null) {
        response = Response.status(Status.OK).type("application/x-javascript")
            .entity(new Gson().toJson(resp)).build();
      } else {
        response = Response.status(Status.OK).type("application/json")
            .entity(new Gson().toJson(resp)).build();
      }
    }

    return response;
  }

  /**
   * 
   * @return Returns the main menu elements of the app
   */
  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Path("/dashboard")
  @GET
  public Response dashboard(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback) {
    System.out.println("Dashboard request received\n\n");
    Set<DashboardElement> dashboard = query.dashboard();

    Response response = null;
    if (format != null && format.equals("xml")) {
      XStream xStream = new XStream(new DomDriver());
      xStream.alias("dashboard", java.util.Set.class);

      if (callback != null) {
        response = Response.status(Status.OK).type("application/x-javascript")
            .entity(xStream.toXML(dashboard)).build();
      } else {
        response = Response.status(Status.OK).type("application/xml")
            .entity(xStream.toXML(dashboard)).build();
      }

    } else {
      if (callback != null) {
        response = Response.status(Status.OK).type("application/x-javascript")
            .entity(new Gson().toJson(dashboard)).build();
      } else {
        response = Response.status(Status.OK).type("application/json")
            .entity(new Gson().toJson(dashboard)).build();
      }
    }

    return response;
  }

  /**
   * Retrieves topics
   * 
   * @return Returns topics
   */
  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Path("/topics")
  @GET
  public Response topics(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback) {
    System.out.println("Topics request received\n\n");
    Set<Topic> topics = query.topics();

    Response response = null;
    if (format != null && format.equals("xml")) {
      XStream xStream = new XStream(new DomDriver());
      xStream.alias("topics", java.util.Set.class);

      if (callback != null) {
        response = Response.status(Status.OK).type("application/x-javascript")
            .entity(xStream.toXML(topics)).build();
      } else {
        response = Response.status(Status.OK).type("application/xml").entity(xStream.toXML(topics))
            .build();
      }

    } else {
      if (callback != null) {
        response = Response.status(Status.OK).type("application/x-javascript")
            .entity(new Gson().toJson(topics)).build();
      } else {
        response = Response.status(Status.OK).type("application/json")
            .entity(new Gson().toJson(topics)).build();
      }
    }

    return response;
  }

  /**
   * Retrieves item of the specific type specified topic id
   * 
   * @param topicId
   * @return
   */
  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Path("/items/{itemType}/{topicId}")
  @GET
  public Response items(@PathParam("itemType") final String itemType,
      @PathParam("topicId") final long topicId, @PathParam("page") final int page,
      @PathParam("offset") final int offset, @QueryParam("format") final String format,
      @QueryParam("callback") final String callback) {

    System.out.println("Items request received\n\n");
    Set<Item> items = query.items(itemType, topicId, page, offset);

    Response response = null;
    if (format != null && format.equals("xml")) {
      XStream xStream = new XStream(new DomDriver());
      xStream.alias("items", java.util.Set.class);

      if (callback != null) {
        response = Response.status(Status.OK).type("application/x-javascript")
            .entity(xStream.toXML(items)).build();
      } else {
        response = Response.status(Status.OK).type("application/xml").entity(xStream.toXML(items))
            .build();
      }

    } else {
      if (callback != null) {
        response = Response.status(Status.OK).type("application/x-javascript")
            .entity(new Gson().toJson(items)).build();
      } else {
        response = Response.status(Status.OK).type("application/json")
            .entity(new Gson().toJson(items)).build();
      }
    }

    return response;
  }

  /**
   * A success message to send to a client when a request has been processed successfully
   * 
   * @return
   */
  public Map<String, Object> success() {
    Map<String, Object> success = new HashMap<String, Object>();
    success.put("code", 200);
    success.put("message", "Processing successful");

    return success;
  }

  /**
   * A failure message to send when a request processing failed
   * 
   * @return
   */
  public Map<String, Object> failure() {
    Map<String, Object> failure = new HashMap<String, Object>();
    failure.put("code", 201);
    failure.put("message", "Processing failed");

    return failure;
  }
}
