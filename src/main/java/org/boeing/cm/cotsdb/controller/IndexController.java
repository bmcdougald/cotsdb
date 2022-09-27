package org.boeing.cm.cotsdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The controller class for the index screen.
 */
@Controller
@RequestMapping("/")
public class IndexController {

  /**
   * index screen
   *
   * @param model model
   * @return Transition destination
   */
  @RequestMapping("index")
  public String index(Model model) {
    return "index";
  }
}
