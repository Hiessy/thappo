package org.thappo.domain.exception;

import java.util.List;

import org.thappo.commons.exception.BusinessException;
import org.thappo.commons.model.Cause;

public class ValidationException
    extends BusinessException {

    private static final long serialVersionUID = 1L;

    public ValidationException(List<Cause> causes) {
        super(causes);
    }

    public ValidationException(Cause... causes) {
        super(causes);
    }

    public ValidationException(String message, List<Cause> causes) {
        super(message, causes);
    }

}
