package calcchange;

public enum Coins {
    PENNY(.01),
    NICKEL(.05),
    DIME(.10),
    QUARTER(.25),
    DOLLAR(1.00);

    private double value;

    Coins(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
