package app.model;

/**
 * Created by User on 06/07/2017.
 * This needs to have a constructor without parameter, getter and setter for JSON
 */
public class Receipt {
    private int amount ;

    public Receipt() {
    }

    public Receipt(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
