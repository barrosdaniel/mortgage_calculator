package mortgage_calculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    private double loanAmount;
    private double annualInterestRate;
    private int years;
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
        loanAmount = Double.parseDouble(input.nextLine());
        System.out.print("Enter annual interest rate [%]: ");
        annualInterestRate = Double.parseDouble(input.nextLine());
        System.out.print("Enter loan period [years]: ");
        years = Integer.parseInt(input.nextLine());
    }

    private void calculateMonthlyAmount() {
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        int numberOfMonths = years * 12;
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
