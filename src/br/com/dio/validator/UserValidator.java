package br.com.dio.validator;

import br.com.dio.exception.ValidatorException;
import br.com.dio.model.UserModel;

public class UserValidator {

    private UserValidator(){

    }

    public static void verifyModel(UserModel model) throws ValidatorException {
        if(stringIsBlank(model.getName()))
            throw new ValidatorException("Informe um nome válido!");
        if(model.getName().length() <= 2)
            throw new ValidatorException("O nome deve ter pelo menos 3 caracteres.");
        if(stringIsBlank(model.getEmail()))
            throw new ValidatorException("Insira um email válido.");
        if(!model.getEmail().contains("@") || (!model.getEmail().contains(".")))
            throw new ValidatorException("Insira um email válido.");
    }

    private static boolean stringIsBlank(final String value){
        return value == null || value.isBlank();
    }
}
