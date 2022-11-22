package org.matias.models;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

import static org.matias.Constants.*;

public class ValidatedObject {

    @Valid
    @NotNull(message = A_REQUIRED)
    public A a;

    @Valid
    @NotNull(message = B_REQUIRED)
    @Size(min = 1, message = B_NOT_EMPTY)
    public ArrayList<BElement> b;

    @Valid
    public ArrayList<CElement> c;

}