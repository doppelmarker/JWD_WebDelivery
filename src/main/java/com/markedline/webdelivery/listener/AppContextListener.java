package com.markedline.webdelivery.listener;

import com.markedline.webdelivery.db.pool.ConnectionPool;
import com.markedline.webdelivery.db.pool.ConnectionPoolException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(AppContextListener.class);
    private static final String GO_TO_ERROR_PAGE = "/error.jsp";
    private static final String ERROR_INIT_CONNECTION_POOL = "Connection pool init error.";
    private static final String ERROR_DESTROY_CONNECTION_POOL = "Connection pool destroy error.";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ConnectionPool.getInstance();
        } catch (ConnectionPoolException e) {
            servletContextEvent.getServletContext().getRequestDispatcher(GO_TO_ERROR_PAGE);
            logger.log(Level.FATAL, ERROR_INIT_CONNECTION_POOL);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            ConnectionPool.getInstance().destroy();
        } catch (ConnectionPoolException e) {
            servletContextEvent.getServletContext().getRequestDispatcher(GO_TO_ERROR_PAGE);
            logger.log(Level.FATAL, ERROR_DESTROY_CONNECTION_POOL);
        }
    }
}
