package org.matias.models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import static org.matias.Constants.*;


public class CElement {

    @NotBlank(message = C_R_NOT_BLANK)
    @NotEmpty(message = C_R_REQUIRED)
    public String r;

    @NotBlank(message = C_S_NOT_BLANK)
    @NotEmpty(message = C_S_REQUIRED)
    public String s;


}