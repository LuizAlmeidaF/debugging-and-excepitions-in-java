package br.com.dio.validator;

import br.com.dio.exception.ValidatorException;
import br.com.dio.model.UserModel;

public class UserValidator {

    private UserValidator(){

    }

    public static void VerifyModel(UserModel model) throws ValidatorException {
        if(model.getName() == null || model.getName().isEmpty()) throw new ValidatorException("");

    }
}
