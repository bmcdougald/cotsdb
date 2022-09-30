package org.boeing.cm.cotsdb;

import java.nio.charset.StandardCharsets;

// This validator is missing for some reason now that I've updated Spring and Gradle
//import org.hibernate.validator.messageinterpolation.AbstractMessageInterpolator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Web configuration class.
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

// Commenting out the Message interpolator/validator because the import of this is broken
// above and can't find the new one

//  @Override
//  public Validator getValidator() {
//
//    // ValidationMessages.UTF to properties-Allows you to set with 8.
//    ReloadableResourceBundleMessageSource messageSource =
//        new ReloadableResourceBundleMessageSource();
//    messageSource.setBasename(AbstractMessageInterpolator.USER_VALIDATION_MESSAGES);
//    messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
//
//    LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
//    validator.setValidationMessageSource(messageSource);
//
//    return validator;
//  }
}
