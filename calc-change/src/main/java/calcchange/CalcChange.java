package calcchange;

public class CalcChange {

    public static void main(String[] args) {
        if(args.length != 1) {
            throw new IllegalArgumentException("Invalid arguments");
        }

        //1234.43
        System.out.println("Dollars: ");
        System.out.println("Quarters: ");
        System.out.println("Dimes: ");
        System.out.println("Nickels: ");
        System.out.println("Pennies: ");

    }
}
