package org.thappo.commons.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.thappo.commons.model.Cause;

public abstract class BusinessException
    extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private List<Cause> causes;

    public BusinessException(List<Cause> causes) {
        this.causes = causes;
    }

    public BusinessException(Cause... causes) {
        this.causes = new ArrayList<Cause>(Arrays.asList(causes));
    }

    public BusinessException(String message, List<Cause> causes) {
        super(message);
        this.causes = causes;
    }

    public List<Cause> getCauses() {
        return this.causes;
    }

}
