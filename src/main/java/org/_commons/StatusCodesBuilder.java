package org._commons;

import java.util.HashSet;
import java.util.Set;

public final class StatusCodesBuilder {

    private static int current = 999;
    private static Set<String> appStatusNames;
    private static StatusCodesBuilder instance;

    private static final Boolean BLOCK = true;

    private StatusCodesBuilder() {

        StatusCodesBuilder.appStatusNames = new HashSet<>();
    }

    public static StatusCodesBuilder getInstance() {

        if(instance == null) {
            synchronized (BLOCK)
            {
                if(instance == null) {
                    instance = new StatusCodesBuilder();
                }
            }
        }
        return instance;
    }

    public synchronized StatusCodeModel generateStatusModel(final Integer httpCode, final String statusCodeName, final String message) {

        if(StatusCodesBuilder.appStatusNames.contains(statusCodeName)) {
            throw new RuntimeException("The status code name "+ statusCodeName + " already exist");
        }

        StatusCodesBuilder.current++;
        final int index = StatusCodesBuilder.current;
        StatusCodesBuilder.appStatusNames.add(statusCodeName);

        final StatusCodeModel model =
                new StatusCodeModel.Builder()
                    .setAppStatusCode(index)
                    .setAppStatusName(statusCodeName)
                    .setHttpCode(httpCode)
                    .setAppStatusMessage(message)
                    .build();

        return model;
    }
}
