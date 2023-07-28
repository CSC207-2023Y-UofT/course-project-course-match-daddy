package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

public class LoginPresenter {

    private String displayMessage;

    /**
     * Constructs a new LoginPresenter object with an initial empty display message.
     * This constructor is used to create an instance of the presenter.
     */
    public LoginPresenter() {
        this.displayMessage = "";
    }

    /**
     * Sets the display message to be shown in the View (UI).
     * The display message contains information about the login process or any other relevant updates.
     *
     * @param displayMessage The message to be displayed in the View.
     */
    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    /**
     * Retrieves the current display message set in the presenter.
     * The View can call this method to obtain the latest display message for updating the UI.
     *
     * @return The current display message to be shown in the View.
     */
    public String getDisplayMessage() {
        return displayMessage;
    }
}
