package org.matias.models;


import javax.validation.constraints.NotEmpty;

public class CElement {

    @NotEmpty(message = "A is required")
    public String r;

    @NotEmpty(message = "A is required")
    public String s;


}