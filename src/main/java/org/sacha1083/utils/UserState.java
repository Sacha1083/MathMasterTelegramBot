package org.sacha1083.utils;

public class UserState {
    private String currentFigure;
    private String expectedResponse;

    public UserState() {
        this.currentFigure = "";
        this.expectedResponse = "";
    }

    public String getCurrentFigure() {
        return currentFigure;
    }

    public void setCurrentFigure(String currentFigure) {
        this.currentFigure = currentFigure;
    }

    public String getExpectedResponse() {
        return expectedResponse;
    }

    public void setExpectedResponse(String expectedResponse) {
        this.expectedResponse = expectedResponse;
    }
}