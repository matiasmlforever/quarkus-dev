package org.matias.service;

import org.matias.models.ValidatedObject;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
@ApplicationScoped
public class DataValidationService {
    public void validateValidatedObject(@Valid ValidatedObject validatedObject) {
        //service business logic
    }
}
