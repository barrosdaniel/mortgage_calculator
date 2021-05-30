package mortgage_calculator;

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
    }

    private void getDetails() {
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------------");
        System.out.println("DB Mortgage Calculator");
        System.out.println("------------------------------");
        System.out.println("\nEnter loan amount: ");
        loanAmount = Double.parseDouble(input.nextLine());
        System.out.println("\nEnter annual interest rate [%]: ");
        annualInterestRate = Double.parseDouble(input.nextLine());
        System.out.println("\nEnter loan period [years]: ");
        years = Integer.parseInt(input.nextLine());
    }

    private void calculateMonthlyAmount() {
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        int numberOfMonths = years * 12;
        monthlyAmount = loanAmount (monthlyInterestRate * Math.pow(, ))

    }

    private void displayMonthlyAmount() {
        System.out.println("\nMortgage monthly payments: " + monthlyAmount);
    }

    public static void main(String[] args) {
        new MortgageCalculator();
    }
}
