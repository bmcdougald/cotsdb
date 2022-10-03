package org.boeing.cm.cotsdb.controller;

import org.boeing.cm.cotsdb.model.License;
import org.boeing.cm.cotsdb.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * License screen controller class.
 */
@Controller
@RequestMapping("/licenses")
public class LicenseController {

  /** Create/update/Redirect destination URL after deletion is completed */
  private static final String REDIRECT_URL = "redirect:/licenses/";

  /** HTML Path */
  private static final String PATH_LIST = "license/list";
  private static final String PATH_CREATE = "license/create";
  private static final String PATH_UPDATE = "license/update";

  /** Model Attribute Name */
  private static final String MODEL_ATTRIBUTE_NAME = "license";

  /** License Repository */
  @Autowired
  private LicenseRepository licenseRepository;

  /**
   * Display the List Screen
   *
   * @param model model
   * @return Transition destination
   */
  @GetMapping(value = "/")
  public String list(Model model) {
    model.addAttribute(MODEL_ATTRIBUTE_NAME, licenseRepository.findAll(Sort.by("id")));
    return PATH_LIST;
  }

  /**
   * Display the Add Product Screen
   *
   * @param model model
   * @return Transition destination
   */
  @GetMapping(value = "/create")
  public String create(Model model) {
    model.addAttribute(MODEL_ATTRIBUTE_NAME, new License());
    return PATH_CREATE;
  }

  /**
   * Perform Add Product
   *
   * @param license Product screen input value
   * @param result Input check result
   * @return Transition destination
   */
  @PostMapping(value = "/create")
  public String create(@Validated @ModelAttribute(MODEL_ATTRIBUTE_NAME) License license,
      BindingResult result) {

    if (result.hasErrors()) {
      return PATH_CREATE;
    }

    licenseRepository.save(license);
    return REDIRECT_URL;
  }

  /**
   * Display the Update Screen
   *
   * @param id Product screen input value
   * @param model Input check result
   * @return Transition destination
   */
  @GetMapping(value = "/{id}/update")
  public String update(@PathVariable("id") Long id, Model model) {
    model.addAttribute(MODEL_ATTRIBUTE_NAME, licenseRepository.getOne(id));
    return PATH_UPDATE;
  }

  /**
   * Perform the Update
   *
   * @param license Product screen input value
   * @param result Input check result
   * @return Transition destination
   */
  @PostMapping(value = "/{id}/update")
  public String update(@Validated @ModelAttribute(MODEL_ATTRIBUTE_NAME) License license,
      BindingResult result) {

    if (result.hasErrors()) {
      return PATH_UPDATE;
    }

    licenseRepository.save(license);
    return REDIRECT_URL;
  }

  /**
   * Perform Deletion
   *
   * @param id license ID
   * @return Transition destination
   */
  @GetMapping(value = "/{id}/delete")
  public String list(@PathVariable("id") Long id) {
    licenseRepository.deleteById(id);
    return REDIRECT_URL;
  }
}
