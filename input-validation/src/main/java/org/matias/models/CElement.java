package org.matias.models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CElement {

    @NotEmpty(message="A is required")
    public String r;

    @NotEmpty(message="A is required")
    public String s;


}