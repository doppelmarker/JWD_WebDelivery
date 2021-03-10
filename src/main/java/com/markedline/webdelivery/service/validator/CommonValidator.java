package com.markedline.webdelivery.service.validator;

import com.markedline.webdelivery.service.validator.info.ValidationInfo;

public interface CommonValidator {
    boolean validate(ValidationInfo info) throws ValidatorException;
}
