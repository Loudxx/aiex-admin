package com.aiex.admin;


import com.aiex.framework.boot.autoconfigure.AiExBootApplication;
import com.aiex.framework.boot.core.AiExApplication;

@AiExBootApplication
public class AiExStartApplication {

    public static void main(String[] args) {
        AiExApplication.run(AiExStartApplication.class, args);
    }

}
