package com.mySampleApplication.server.manualwes; /**
 * Created by avd on 2016-03-05.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.websocket.DeploymentException;
import java.util.logging.Logger;

public class ManualWebsocketRegistererListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public static final Logger LOGGER = Logger.getLogger(ManualWebsocketRegistererListener.class.getName());

    // Public constructor is required by servlet spec
    public ManualWebsocketRegistererListener() {
    }
	
	/*
##      ##    ###    ########  ##    ## #### ##    ##  ######      #### 
##  ##  ##   ## ##   ##     ## ###   ##  ##  ###   ## ##    ##     #### 
##  ##  ##  ##   ##  ##     ## ####  ##  ##  ####  ## ##           #### 
##  ##  ## ##     ## ########  ## ## ##  ##  ## ## ## ##   ####     ##  
##  ##  ## ######### ##   ##   ##  ####  ##  ##  #### ##    ##          
##  ##  ## ##     ## ##    ##  ##   ###  ##  ##   ### ##    ##     #### 
 ###  ###  ##     ## ##     ## ##    ## #### ##    ##  ######      ####
 	*/

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        javax.websocket.server.ServerContainer serverContainer =
                (javax.websocket.server.ServerContainer)
                        sce.getServletContext().getAttribute("javax.websocket.server.ServerContainer");
        ManualWebsocketEndpointConfig sec = new ManualWebsocketEndpointConfig();
        if(serverContainer==null){
            LOGGER.warning("\n" +
                    "##      ##    ###    ########  ##    ## #### ##    ##  ######      #### \n" +
                    "##  ##  ##   ## ##   ##     ## ###   ##  ##  ###   ## ##    ##     #### \n" +
                    "##  ##  ##  ##   ##  ##     ## ####  ##  ##  ####  ## ##           #### \n" +
                    "##  ##  ## ##     ## ########  ## ## ##  ##  ## ## ## ##   ####     ##  \n" +
                    "##  ##  ## ######### ##   ##   ##  ####  ##  ##  #### ##    ##          \n" +
                    "##  ##  ## ##     ## ##    ##  ##   ###  ##  ##   ### ##    ##     #### \n" +
                    " ###  ###  ##     ## ##     ## ##    ## #### ##    ##  ######      #### \n" +
                    "\n" +
                    "DEAR PROGRAMMER: You are probably using Jetty. Websocket server container was not found in Servlet Context.");
            tryRegisteringConfigViaGenericServlet(sce, sec);
        } else
        try {
            serverContainer.addEndpoint(sec);
        } catch (DeploymentException e) {
            System.out.println("Error deploying websocket");
        }
    }

    private void tryRegisteringConfigViaGenericServlet(ServletContextEvent sce, ManualWebsocketEndpointConfig sec) {
        sce.getServletContext().addServlet();
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
