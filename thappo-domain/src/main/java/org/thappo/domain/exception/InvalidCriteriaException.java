package org.thappo.domain.exception;

import java.util.List;

import org.thappo.commons.exception.BusinessException;
import org.thappo.commons.model.Cause;


public class InvalidCriteriaException
    extends BusinessException {

    private static final long serialVersionUID = 1L;

    public InvalidCriteriaException(List<Cause> causes) {
        super(causes);
    }

    public InvalidCriteriaException(Cause... causes) {
        super(causes);
    }

    public InvalidCriteriaException(String message, List<Cause> causes) {
        super(message, causes);
    }

}
