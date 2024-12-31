package com.bornfire.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterestCalculator {

	public static void main(String[] args) {
		
		  // Principal amount and annual interest rate
        BigDecimal principal = new BigDecimal("100000"); // 100,000
        BigDecimal annualInterestRate = new BigDecimal("7"); // 8%

        // Convert interest rate to a decimal (8% -> 0.08)
        BigDecimal yearlyInterestRate = annualInterestRate.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);

        // Calculate yearly interest
        BigDecimal yearlyInterest = principal.multiply(yearlyInterestRate).setScale(2, RoundingMode.HALF_UP);;
        System.out.println("Yearly Interest: " + yearlyInterest);

        // Calculate monthly interest (divide by 12)
        BigDecimal monthsInYear = BigDecimal.valueOf(12);
        BigDecimal monthlyInterestRate = yearlyInterestRate.divide(monthsInYear, 10, RoundingMode.HALF_UP);
        BigDecimal monthlyInterest = principal.multiply(monthlyInterestRate).setScale(2, RoundingMode.HALF_UP);;
        System.out.println("Monthly Interest: " + monthlyInterest);

        // Calculate daily interest (assuming 365 days in a year)
        BigDecimal daysInYear = BigDecimal.valueOf(365);
        BigDecimal dailyInterestRate = yearlyInterestRate.divide(daysInYear, 10, RoundingMode.HALF_UP);
        BigDecimal dailyInterest = principal.multiply(dailyInterestRate).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Daily Interest: " + dailyInterest);

	}

}
