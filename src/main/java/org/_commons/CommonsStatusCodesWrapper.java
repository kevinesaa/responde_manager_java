package org._commons;

public abstract class CommonsStatusCodesWrapper {

    private static Boolean sync = false;

    protected CommonsStatusCodesWrapper(final StatusCodesBuilder statusCodesBuilder) {
        init(statusCodesBuilder);
        if(!isModuleSync()) {
            initModule(statusCodesBuilder);
            markModuleAsSync();
        }
    }

    protected abstract void initModule(final StatusCodesBuilder statusCodesBuilder);
    protected abstract boolean isModuleSync();
    protected abstract void markModuleAsSync();

    private synchronized void init(final StatusCodesBuilder statusCodesBuilder) {

        if(!sync) {
            OK = statusCodesBuilder.generateStatusModel(200,"OK",null);
            UNKNOWN_ERROR = statusCodesBuilder.generateStatusModel(500,"UNKNOWN_ERROR","ups this");
            BAD_FORMAT_EMAIL = statusCodesBuilder.generateStatusModel(400,"BAD_FORMAT_EMAIL","not valid email format");
            sync = true;
        }
    }

    public static StatusCodeModel OK;
    public static StatusCodeModel BAD_FORMAT_EMAIL;
    public static StatusCodeModel UNKNOWN_ERROR;

}
