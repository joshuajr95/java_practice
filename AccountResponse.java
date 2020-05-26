public class AccountResponse {

    private final Float currentBalance;
    private final String message;

    public AccountResponse(Float currentBalance, String message) {
        this.currentBalance = currentBalance;
        this.message = message;
    }

    public Float getCurrentBalance() {
        return new Float(currentBalance);
    }

    public String getMessage() {
        return new String(message);
    }
}
