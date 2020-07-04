package banking;

public class Session {
    private String activeCardNumber;
    private boolean exitTriggered;

    public String getActiveCardNumber() {
        return activeCardNumber;
    }

    public void login(String activeCardNumber) {
        this.activeCardNumber = activeCardNumber;
    }

    public void logout() {
        activeCardNumber = null;
    }

    public boolean isLoggedIn() {
        return activeCardNumber != null;
    }

    public void triggerExit() {
        exitTriggered = true;
    }

    public boolean isExitTriggered() {
        return exitTriggered;
    }
}
