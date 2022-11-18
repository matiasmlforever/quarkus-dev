package org.matias.models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BElement {

    @NotBlank(message="B.p may not be blank")
    @NotNull(message="B.p is required")
    public String p;

    @NotBlank(message="B.q may not be blank")
    @NotNull(message="B.q is required")
    public long q;


}