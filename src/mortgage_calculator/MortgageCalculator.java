package mortgage_calculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;
    private float loanAmount;
    private float annualInterestRate;
    private byte years;
    private double monthlyAmount;


    public MortgageCalculator() {
        loanAmount = 0;
        annualInterestRate = 0;
        years = 0;
        monthlyAmount = 0;
        getDetails();
        calculateMonthlyAmount();
        displayMonthlyAmount();
    }

    private void getDetails() {
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------------");
        System.out.println("DB Mortgage Calculator");
        System.out.println("------------------------------");
        System.out.print("\nEnter loan amount: ");
        loanAmount = Float.parseFloat(input.nextLine());
        System.out.print("Enter annual interest rate [%]: ");
        annualInterestRate = Float.parseFloat(input.nextLine());
        System.out.print("Enter loan period [years]: ");
        years = Byte.parseByte(input.nextLine());
    }

    private void calculateMonthlyAmount() {
        double monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
        int numberOfMonths = years * MONTHS_IN_YEAR;
        monthlyAmount =
                loanAmount * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths)) / (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
    }

    private void displayMonthlyAmount() {
        NumberFormat monthlyAmountDollars = NumberFormat.getCurrencyInstance();
        String amountToDisplay =
                monthlyAmountDollars.format(monthlyAmount);
        System.out.println("\nMortgage monthly payments: " + amountToDisplay);
    }

    public static void main(String[] args) {
        new MortgageCalculator();
    }
}
