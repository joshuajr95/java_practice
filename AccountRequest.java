public class AccountRequest {

    private final char type;
    private final Float amount;


    public AccountRequest(char type, Float amount) {

        if (type != 'w' && type != 'd') {
            throw new IllegalArgumentException();
        }

        this.type = type;
        this.amount = amount;
    }

    public char getType() {
        return type;
    }

    public Float getAmount() {
        return new Float(amount);
    }
}
