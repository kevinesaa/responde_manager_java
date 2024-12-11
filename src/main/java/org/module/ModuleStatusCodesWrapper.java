package org.module;

import org._commons.CommonsStatusCodesWrapper;
import org._commons.StatusCodesBuilder;
import org._commons.StatusCodeModel;

public class ModuleStatusCodesWrapper extends CommonsStatusCodesWrapper {

    private static Boolean sync = false;
    public static StatusCodeModel MODULE_STATUS;
    private static ModuleStatusCodesWrapper instance;
    private static final Boolean BLOCK = true;

    private ModuleStatusCodesWrapper(final StatusCodesBuilder statusCodesBuilder) {
        super(statusCodesBuilder);
    }

    public static ModuleStatusCodesWrapper getInstance(final StatusCodesBuilder statusCodesBuilder) {
        if(instance == null) {
            synchronized (BLOCK) {
                if(instance == null){
                    instance = new ModuleStatusCodesWrapper(statusCodesBuilder);
                }
            }
        }
        return instance;
    }

    @Override
    protected void initModule(final StatusCodesBuilder statusCodesBuilder) {
        MODULE_STATUS = statusCodesBuilder.generateStatusModel(400,"MODULE_STATUS","test");
    }

    @Override
    protected boolean isModuleSync() {
        return sync;
    }

    @Override
    protected void markModuleAsSync() {
        sync = true;
    }
}
