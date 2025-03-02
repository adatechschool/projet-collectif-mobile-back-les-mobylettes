package com.lesbonnesoeufs.lesmobylettes.lesmobylettes.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcesNotFoundException extends Exception{

  @Serial
  private static final long serialVersionUID = 1L;

  public ResourcesNotFoundException(String message) {
    super(message);
  }
}

