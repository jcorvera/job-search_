package com.jobSearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLIKeywordValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        if (!value.matches("^[a-zA-Z]+[0-9]]*$")) {
            System.out.println("Keyword is invalid !");
            throw  new ParameterException("Enter just characters");
        }
    }
}
