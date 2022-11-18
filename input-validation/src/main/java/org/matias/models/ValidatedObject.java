package org.matias.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

public class ValidatedObject {

    @NotNull(message="A is required")
    public A a;

    @NotNull(message="B is required")
    @Size(min = 1, message = "B too small")
    public ArrayList<BElement> b;

    public ArrayList<CElement> c;

}