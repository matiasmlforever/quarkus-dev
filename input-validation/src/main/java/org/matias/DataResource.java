package org.matias;

import org.matias.models.ValidatedObject;
import org.matias.service.DataValidationService;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;
import java.util.stream.Collectors;


@Path("/data")
public class DataResource {
    @Inject
    DataValidationService dataValidationService;

    @Inject
    Validator validator;


    public static class Result {

        Result(String message) {
            this.success = true;
            this.message = message;
        }

        Result(Set<? extends ConstraintViolation<?>> violations) {
            this.success = false;
            this.message = violations.stream()
                    .map(cv -> cv.getMessage())
                    .collect(Collectors.joining(", "));
        }

        private String message;
        private boolean success;

        public String getMessage() {
            return message;
        }

        public boolean isSuccess() {
            return success;
        }

    }


    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/manual-validation")
    @POST
    public Result tryMeManualValidation(ValidatedObject vobject) {
        Set<ConstraintViolation<ValidatedObject>> violations = validator.validate(vobject);
        if (violations.isEmpty()) {
            return new Result("tryMeManualValidation - is valid! It was validated by manual validation.");
        } else {
            return new Result(violations);
        }
    }

    @Path("/end-point-method-validation")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result tryMeEndPointMethodValidation(@Valid ValidatedObject vobject) {
        return new Result("tryMeEndPointMethodValidation - is valid! It was validated by end point method validation.");
    }


    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/service-method-validation")
    @POST
    public Result tryMeServiceMethodValidation(ValidatedObject vobject) {
        try {
            dataValidationService.validateValidatedObject(vobject);
            return new Result("tryMeServiceMethodValidation is valid! It was validated by service method validation.");
        } catch (ConstraintViolationException e) {
            return new Result(e.getConstraintViolations());
        }
    }

}