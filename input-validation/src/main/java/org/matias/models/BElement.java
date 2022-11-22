package org.matias.models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static org.matias.Constants.*;

public class BElement {

    @NotBlank(message = B_P_NOT_BLANK)
    @NotNull(message = B_P_REQUIRED)
    public String p;

    @NotNull(message = B_Q_REQUIRED)
    public Long q;


}