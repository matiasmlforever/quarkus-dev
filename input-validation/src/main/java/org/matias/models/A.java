package org.matias.models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class A {

    @NotBlank(message="A.i may not be blank")
    @NotNull(message="A.i is required")
    public String i;

    @NotBlank(message="A.t may not be blank")
    @NotNull(message="A.t required")
    public String t;

}