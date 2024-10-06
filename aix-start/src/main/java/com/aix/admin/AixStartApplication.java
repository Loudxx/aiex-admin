package com.aix.admin;

import com.aix.framework.boot.autoconfigure.AixBootApplication;
import com.aix.framework.boot.core.AixApplication;

@AixBootApplication
public class AixStartApplication {

    public static void main(String[] args) {
        AixApplication.run(AixStartApplication.class, args);
    }

}
