package org.example.Model.Validator;

import java.util.HashMap;

public class Validator {
    private static final Validator INSTANCE = new Validator();

    private HashMap<String, String> stringStringHashMap = new HashMap<>();

    public void setError(String code, String message)
    {
        stringStringHashMap.put(code, message);
    }
    public HashMap getError()
    {
        return stringStringHashMap;
    }

    public void clear()
    {
        stringStringHashMap.clear();
    }

    public static Validator getInstance()
    {
        return INSTANCE;
    }

}
