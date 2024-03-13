package org.example.Model.Validator;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;

public class ValidatorException extends Exception {

    @Getter
    HashMap<String, String> stringStringHashMap;

    public ValidatorException(HashMap errors)
    {
        this.stringStringHashMap = errors;
    }
}
