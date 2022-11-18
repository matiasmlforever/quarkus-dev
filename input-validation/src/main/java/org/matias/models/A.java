package org.matias.models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class A {

    @NotBlank(message="A.uuid may not be blank")
    @NotNull(message="A.uuid is required")
    public UUID uuid;

    @NotBlank(message="A.datetime may not be blank")
    @NotNull(message="A.datetime required")
    public String datetime;

}