package com.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class SessionController {
  @Value("${server.port}")
  private String port;
  @RequestMapping("/setSession")
  public String setSession(HttpServletRequest request, String name) {
	HttpSession session = request.getSession();
	session.setAttribute("name", name);
	return session.getId() + "===" + name+port;
  }

  @RequestMapping("/getSession")
  public String getSession(HttpServletRequest request) {
	HttpSession session = request.getSession(false);
	if (session == null) {
	  return "session为空";
	}
	String name = (String) session.getAttribute("name");
	return name + session.getId()+port;
  }
  @RequestMapping("/")
  public String getPort(){
    return port;
  }
}
