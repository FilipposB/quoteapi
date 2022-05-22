package com.rquoteapi.quoteapi;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class URIErrorController implements ErrorController{

  private static Logger logger = LoggerFactory.getLogger(URIErrorController.class);

  @RequestMapping("/error")
  @ResponseBody
  String error(HttpServletRequest request) {
    logger.error("URI is wrong, only /quote is supported !");
    return "<h1>Error occurred this URI Doesn't Exist</h1>";
  }
}
