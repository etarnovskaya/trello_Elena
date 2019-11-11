package com.trello.qa.tests;

import com.trello.qa.manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Arrays;

public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);
  @BeforeMethod
  public void startLogger(Method m, Object[] p){
    logger.info("start test " + m.getName() + " with parameters " + Arrays.asList(p));
  }

  @AfterMethod
  public void stopLogger(Method m){
    logger.info("stop test " + m.getName());
    System.out.println("------------------------------------------------------------------------");
  }
  protected static ApplicationManager app =
          new ApplicationManager();

  @BeforeSuite
  public void setUp() throws MalformedURLException, InterruptedException {
    app.init();
  }

  @AfterSuite
  public void tearDown() throws InterruptedException {
    app.stop();
  }

}
