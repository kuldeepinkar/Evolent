package com.example.evolent.contact;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ContactNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ContactNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String contactNotFoundHandler(ContactNotFoundException ex) {
    return ex.getMessage();
  }
  
  @ResponseBody
  @ExceptionHandler(PhoneNumberException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  String contactNotCorrectHandler(PhoneNumberException ex) {
    return ex.getMessage();
  }
  
  @ResponseBody
  @ExceptionHandler(NameException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  String contactNotCorrectHandler(NameException ex) {
    return ex.getMessage();
  }
  
  @ResponseBody
  @ExceptionHandler(EmailException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  String contactNotCorrectHandler(EmailException ex) {
    return ex.getMessage();
  }
  
}