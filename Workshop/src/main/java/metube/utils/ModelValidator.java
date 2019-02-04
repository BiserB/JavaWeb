package metube.utils;

import metube.models.interfaces.Model;

import javax.validation.Validation;
import javax.validation.Validator;

public class ModelValidator {

    private final Validator validator;

    public ModelValidator() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public boolean isValid(Model model){

        return validator.validate(model).size() == 0;
    }
}
