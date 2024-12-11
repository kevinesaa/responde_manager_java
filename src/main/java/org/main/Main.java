package org.main;

import org._commons.ResponseBuilder;
import org._commons.ResponseModel;
import org._commons.StatusCodesBuilder;
import org.module.ModuleStatusCodesWrapper;

public class Main {

    public static void main(String[] args) {

        ModuleStatusCodesWrapper.getInstance(StatusCodesBuilder.getInstance());
        System.out.println(ModuleStatusCodesWrapper.MODULE_STATUS.getAppStatusName());
        ModuleStatusCodesWrapper.getInstance(StatusCodesBuilder.getInstance());
        System.out.println(ModuleStatusCodesWrapper.BAD_FORMAT_EMAIL.getAppStatusName());

        ResponseModel build = new ResponseBuilder()
                .setControlOrigin()
                .build();
    }
}