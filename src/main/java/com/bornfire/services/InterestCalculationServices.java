package com.bornfire.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import com.bornfire.entities.TestPrincipalCalculation;
import com.ibm.icu.text.SimpleDateFormat;

@Service
@Configuration
@EnableScheduling
public class InterestCalculationServices {

	/* calculate payment schedule without maturity (Praveen) */

	public List<TestPrincipalCalculation> calculatePrincialPaymentNotice(Date creationDate, Date installmentEndDate,
			BigDecimal productValue, BigDecimal product, String installmentFrequency, BigDecimal interestPercentage,
			int numberOfInstallments, BigDecimal installmentAmount, String interestFrequency) {

		String rateCode = "LIN5%";
		String interestDemand = "Interest Demand";
		String regular = "Regular Installment";

		List<TestPrincipalCalculation> principalTable = new ArrayList<>();
		BigDecimal product1=product;
		BigDecimal principal;
		System.out.println("Interest yearly % : " + interestPercentage);

		BigDecimal yearlyInterestRate = interestPercentage.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);

		BigDecimal monthsInYear = BigDecimal.valueOf(12);
		BigDecimal monthlyInterestRate = yearlyInterestRate.divide(monthsInYear, 10, RoundingMode.HALF_UP);
		
		BigDecimal monthlyInterest = product.multiply(monthlyInterestRate).setScale(0, RoundingMode.FLOOR).setScale(2, RoundingMode.HALF_UP);


		BigDecimal daysInYear = BigDecimal.valueOf(365);
		BigDecimal dailyInterestRate = yearlyInterestRate.divide(daysInYear, 10, RoundingMode.HALF_UP);
		BigDecimal dailyInterest = product.multiply(dailyInterestRate).setScale(0, RoundingMode.FLOOR).setScale(2, RoundingMode.HALF_UP);

		System.out.println("Interest rate: " + yearlyInterestRate);
		System.out.println("Monthly Interest : " + monthlyInterest);
		System.out.println("Daily Interest : " + dailyInterest);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(creationDate);

		Calendar calendarFromDate = Calendar.getInstance();
		calendarFromDate.setTime(creationDate);

		LocalDate startDate = convertToLocalDate(creationDate);
		LocalDate endDate = convertToLocalDate(installmentEndDate);
		long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);

		int noOfMonths = (int) monthsBetween;

		for (int i = 1; i <= noOfMonths; i++) {

			TestPrincipalCalculation installment1 = new TestPrincipalCalculation();

			if ("Monthly".equalsIgnoreCase(installmentFrequency)) {

				/* principal - monthly and interest - monthly */

				installment1.setProduct(product);
				installment1.setProductValue(productValue);
				installment1.setInstallmentFrequency(installmentFrequency);
				installment1.setInterestPercentage(interestPercentage);
				installment1.setRateCode(rateCode);
				installment1.setPrincipalOverDue(BigDecimal.ZERO);
				installment1.setInterestOverdue(BigDecimal.ZERO);

				installment1.setInstallmentDescription(regular);

				BigDecimal interest = BigDecimal.ZERO;
				if (i == 1) {
					System.out.println("interest calculation first month");

					/* First Month */

					principal = product1;
				//	System.out.println(principal+" - "+product1);

					interest = dailyInterest;

					principal = product1.subtract(installmentAmount);
					installment1.setPrincipalAmount(installmentAmount);
					installment1.setPrincipalAmountOutstanding(principal);

					product1 = principal;

					installment1.setInstallmentFromDate(calendarFromDate.getTime());

					calendar.add(Calendar.MONTH, 1);
					installment1.setInstallmentDate(calendar.getTime());

					/* Interest Calculation */

					LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
					LocalDate toDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

					installment1.setInterestAmount(
							interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(0, RoundingMode.FLOOR).setScale(2, RoundingMode.HALF_UP));

					calendarFromDate.add(Calendar.MONTH, 1);
					// calendarFromDate.set(Calendar.DAY_OF_MONTH, 1);
					System.out.println(interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.FLOOR) +"ins amt");
				} else {
					System.out.println("interest calculation second month");

					/* All Other Months */

					principal = product1;
					//System.out.println(principal+" - "+product1);
					
					dailyInterest = product1.multiply(dailyInterestRate).setScale(2, RoundingMode.HALF_UP);
					interest = dailyInterest;

					principal = product1.subtract(installmentAmount);

					installment1.setPrincipalAmount(installmentAmount);
					installment1.setPrincipalAmountOutstanding(principal);
					product1 = principal;

					installment1.setInstallmentFromDate(calendarFromDate.getTime());

					calendar.add(Calendar.MONTH, 1);
					installment1.setInstallmentDate(calendar.getTime());

					/* Interest Calculation */

					LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
					LocalDate toDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

					installment1.setInterestAmount(
							interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(0, RoundingMode.FLOOR).setScale(2, RoundingMode.HALF_UP));

					calendarFromDate.add(Calendar.MONTH, 1);
					System.out.println(interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.FLOOR) +"ins amt");
				}
				
				// calendar.add(Calendar.MONTH, 1);
				principalTable.add(installment1);

			} else if ("Quarterly".equalsIgnoreCase(installmentFrequency)) {

				/* principal - Quarterly and interest - monthly */

				installment1.setProduct(product);
				installment1.setProductValue(productValue);
				installment1.setInstallmentFrequency(installmentFrequency);
				installment1.setInterestPercentage(interestPercentage);

				installment1.setRateCode(rateCode);
				installment1.setPrincipalOverDue(BigDecimal.ZERO);
				installment1.setInterestOverdue(BigDecimal.ZERO);

				BigDecimal interest = BigDecimal.ZERO;
				if (i == 0) {

					/* First Month */
					principal = product;

					interest = dailyInterest;

					installment1.setPrincipalAmount(BigDecimal.ZERO);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(interestDemand);

					installment1.setInstallmentFromDate(calendarFromDate.getTime());
					calendar.add(Calendar.MONTH, 1);
					installment1.setInstallmentDate(calendar.getTime());

					/* Interest Calculation */

					LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
					LocalDate toDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

					installment1.setInterestAmount(
							interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

					calendarFromDate.add(Calendar.MONTH, 1);

				} else if (i % 3 == 0 && i != 0) {

					/* At Quarterly Time */

					principal = product;

					interest = dailyInterest;

					principal = product.subtract(installmentAmount);

					installment1.setPrincipalAmount(installmentAmount);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(regular);

					product = principal;

					installment1.setInstallmentFromDate(calendarFromDate.getTime());
					calendar.add(Calendar.MONTH, 1);
					installment1.setInstallmentDate(calendar.getTime());

					/* Interest Calculation */

					LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
					LocalDate toDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

					installment1.setInterestAmount(
							interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

					calendarFromDate.add(Calendar.MONTH, 1);

				} else {

					/* All other Months */

					principal = product;

					interest = dailyInterest;

					installment1.setPrincipalAmount(BigDecimal.ZERO);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(interestDemand);

					installment1.setInstallmentFromDate(calendarFromDate.getTime());
					calendar.add(Calendar.MONTH, 1);
					installment1.setInstallmentDate(calendar.getTime());

					/* Interest Calculation */

					LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
					LocalDate toDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

					installment1.setInterestAmount(
							interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

					calendarFromDate.add(Calendar.MONTH, 1);

				}

				principalTable.add(installment1);

			} else if ("Halfyearly".equalsIgnoreCase(installmentFrequency)) {

				if ("Quarterly".equalsIgnoreCase(interestFrequency)) {

					/* principal - Half yearly and interest - Quarterly */

					installment1.setProduct(product);
					installment1.setProductValue(productValue);
					installment1.setInstallmentFrequency(installmentFrequency);
					installment1.setInterestPercentage(interestPercentage);

					installment1.setRateCode(rateCode);
					installment1.setPrincipalOverDue(BigDecimal.ZERO);
					installment1.setInterestOverdue(BigDecimal.ZERO);

					BigDecimal interest = BigDecimal.ZERO;
					if (i == 0) {

						/* First Month */
						principal = product;

						interest = principal.multiply(monthlyInterestRate);

						installment1.setInterestAmount(interest);
						installment1.setPrincipalAmount(BigDecimal.ZERO);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(interestDemand);

					} else if (i % 3 == 0 && i != 0 && i % 6 != 0) {

						/* Interest time */

						principal = product;

						interest = dailyInterest;

						installment1.setPrincipalAmount(installmentAmount);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(interestDemand);
						product = principal;

						installment1.setInstallmentFromDate(calendarFromDate.getTime());
						calendar.add(Calendar.MONTH, 3);
						installment1.setInstallmentDate(calendar.getTime());

						/* Interest Calculation */

						LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
						LocalDate toDate = convertToLocalDate(calendar.getTime());
						long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

						installment1.setInterestAmount(
								interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

						calendarFromDate.add(Calendar.MONTH, 3);
						principalTable.add(installment1);

					} else if (i % 6 == 0 && i != 0) {

						/* Principal time */

						principal = product;

						interest = dailyInterest;

						principal = product.subtract(installmentAmount);

						installment1.setPrincipalAmount(installmentAmount);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(regular);
						product = principal;

						installment1.setInstallmentFromDate(calendarFromDate.getTime());
						calendar.add(Calendar.MONTH, 3);
						installment1.setInstallmentDate(calendar.getTime());

						/* Interest Calculation */

						LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
						LocalDate toDate = convertToLocalDate(calendar.getTime());
						long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

						installment1.setInterestAmount(
								interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

						calendarFromDate.add(Calendar.MONTH, 3);
						principalTable.add(installment1);

					} else {

						principal = product;

						interest = principal.multiply(monthlyInterestRate);
						installment1.setInterestAmount(interest.setScale(2, RoundingMode.CEILING));

						installment1.setPrincipalAmount(BigDecimal.ZERO);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(interestDemand);

					}

				} else {

					/* principal - Half yearly and interest - monthly */

					installment1.setProduct(product);
					installment1.setProductValue(productValue);
					installment1.setInstallmentFrequency(installmentFrequency);
					installment1.setInterestPercentage(interestPercentage);
					installment1.setRateCode(rateCode);
					installment1.setPrincipalOverDue(BigDecimal.ZERO);
					installment1.setInterestOverdue(BigDecimal.ZERO);

					BigDecimal interest = BigDecimal.ZERO;
					if (i == 0) {

						/* First month */
						principal = product;

						interest = dailyInterest;

						installment1.setPrincipalAmount(BigDecimal.ZERO);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(interestDemand);

						installment1.setInstallmentFromDate(calendarFromDate.getTime());
						calendar.add(Calendar.MONTH, 1);
						installment1.setInstallmentDate(calendar.getTime());

						/* Interest Calculation */

						LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
						LocalDate toDate = convertToLocalDate(calendar.getTime());
						long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

						installment1.setInterestAmount(
								interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

						calendarFromDate.add(Calendar.MONTH, 1);

					} else if (i % 6 == 0 && i != 0) {

						/* principal time */

						principal = product;

						interest = dailyInterest;

						principal = product.subtract(installmentAmount);

						installment1.setPrincipalAmount(installmentAmount);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(regular);
						product = principal;

						installment1.setInstallmentFromDate(calendarFromDate.getTime());
						calendar.add(Calendar.MONTH, 1);
						installment1.setInstallmentDate(calendar.getTime());

						/* Interest Calculation */

						LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
						LocalDate toDate = convertToLocalDate(calendar.getTime());
						long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

						installment1.setInterestAmount(
								interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

						calendarFromDate.add(Calendar.MONTH, 1);

					} else {

						principal = product;

						interest = dailyInterest;

						installment1.setPrincipalAmount(BigDecimal.ZERO);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(interestDemand);

						installment1.setInstallmentFromDate(calendarFromDate.getTime());
						calendar.add(Calendar.MONTH, 1);
						installment1.setInstallmentDate(calendar.getTime());

						/* Interest Calculation */

						LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
						LocalDate toDate = convertToLocalDate(calendar.getTime());
						long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

						installment1.setInterestAmount(
								interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

						calendarFromDate.add(Calendar.MONTH, 1);

					}

					principalTable.add(installment1);
				}

			} else {
				if ("Quarterly".equalsIgnoreCase(interestFrequency)) {

					/* principal - Yearly and interest - Quarterly */

					installment1.setProduct(product);
					installment1.setProductValue(productValue);
					installment1.setInstallmentFrequency(installmentFrequency);
					installment1.setInterestPercentage(interestPercentage);

					installment1.setRateCode(rateCode);
					installment1.setPrincipalOverDue(BigDecimal.ZERO);
					installment1.setInterestOverdue(BigDecimal.ZERO);

					BigDecimal interest = BigDecimal.ZERO;
					if (i == 0) {

						principal = product;

						interest = principal.multiply(monthlyInterestRate);

						installment1.setInterestAmount(interest);
						installment1.setPrincipalAmount(BigDecimal.ZERO);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(interestDemand);

					} else if (i % 3 == 0 && i != 0 && i % 12 != 0) {

						/* Interest time */

						principal = product;

						interest = dailyInterest;

						installment1.setPrincipalAmount(installmentAmount);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(interestDemand);
						product = principal;

						installment1.setInstallmentFromDate(calendarFromDate.getTime());
						calendar.add(Calendar.MONTH, 3);
						installment1.setInstallmentDate(calendar.getTime());

						/* Interest Calculation */

						LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
						LocalDate toDate = convertToLocalDate(calendar.getTime());
						long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

						installment1.setInterestAmount(
								interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

						calendarFromDate.add(Calendar.MONTH, 3);
						principalTable.add(installment1);

					} else if (i % 12 == 0 && i != 0) {

						/* principal time */

						principal = product;

						interest = dailyInterest;

						principal = product.subtract(installmentAmount);

						installment1.setPrincipalAmount(installmentAmount);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(regular);

						product = principal;

						installment1.setInstallmentFromDate(calendarFromDate.getTime());
						calendar.add(Calendar.MONTH, 3);
						installment1.setInstallmentDate(calendar.getTime());

						/* Interest Calculation */

						LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
						LocalDate toDate = convertToLocalDate(calendar.getTime());
						long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

						installment1.setInterestAmount(
								interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

						calendarFromDate.add(Calendar.MONTH, 3);
						principalTable.add(installment1);

					} else {

						principal = product;

						interest = principal.multiply(monthlyInterestRate);
						installment1.setInterestAmount(interest.setScale(2, RoundingMode.CEILING));

						installment1.setPrincipalAmount(BigDecimal.ZERO);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(interestDemand);

					}

				} else if ("Halfyearly".equalsIgnoreCase(interestFrequency)) {

					/* principal - Yearly and interest - Half yearly */

					installment1.setProduct(product);
					installment1.setProductValue(productValue);
					installment1.setInstallmentFrequency(installmentFrequency);
					installment1.setInterestPercentage(interestPercentage);

					installment1.setRateCode(rateCode);
					installment1.setPrincipalOverDue(BigDecimal.ZERO);
					installment1.setInterestOverdue(BigDecimal.ZERO);

					BigDecimal interest = BigDecimal.ZERO;
					if (i == 0) {

						principal = product;

						interest = principal.multiply(monthlyInterestRate);

						installment1.setInterestAmount(interest);
						installment1.setPrincipalAmount(BigDecimal.ZERO);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(interestDemand);

					} else if (i % 6 == 0 && i != 0 && i % 12 != 0) {

						/* Interest time */

						principal = product;

						interest = dailyInterest;

						installment1.setPrincipalAmount(installmentAmount);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(interestDemand);
						product = principal;

						installment1.setInstallmentFromDate(calendarFromDate.getTime());
						calendar.add(Calendar.MONTH, 6);
						installment1.setInstallmentDate(calendar.getTime());

						/* Interest Calculation */

						LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
						LocalDate toDate = convertToLocalDate(calendar.getTime());
						long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

						installment1.setInterestAmount(
								interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

						calendarFromDate.add(Calendar.MONTH, 6);
						principalTable.add(installment1);

					} else if (i % 12 == 0 && i != 0) {

						/* principal time */

						principal = product;

						interest = dailyInterest;

						principal = product.subtract(installmentAmount);

						installment1.setPrincipalAmount(installmentAmount);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(regular);

						product = principal;

						installment1.setInstallmentFromDate(calendarFromDate.getTime());
						calendar.add(Calendar.MONTH, 6);
						installment1.setInstallmentDate(calendar.getTime());

						/* Interest Calculation */

						LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
						LocalDate toDate = convertToLocalDate(calendar.getTime());
						long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

						installment1.setInterestAmount(
								interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

						calendarFromDate.add(Calendar.MONTH, 6);
						principalTable.add(installment1);

					} else {

						principal = product;

						interest = principal.multiply(monthlyInterestRate);
						installment1.setInterestAmount(interest.setScale(2, RoundingMode.CEILING));

						installment1.setPrincipalAmount(BigDecimal.ZERO);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(interestDemand);

					}

				} else {

					/* principal - Yearly and interest - monthly */

					installment1.setProduct(product);
					installment1.setProductValue(productValue);
					installment1.setInstallmentFrequency(installmentFrequency);
					installment1.setInterestPercentage(interestPercentage);

					installment1.setRateCode(rateCode);
					installment1.setPrincipalOverDue(BigDecimal.ZERO);
					installment1.setInterestOverdue(BigDecimal.ZERO);

					BigDecimal interest = BigDecimal.ZERO;
					if (i == 0) {
						principal = product;

						interest = dailyInterest;

						installment1.setPrincipalAmount(BigDecimal.ZERO);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(interestDemand);

						installment1.setInstallmentFromDate(calendarFromDate.getTime());
						calendar.add(Calendar.MONTH, 1);
						installment1.setInstallmentDate(calendar.getTime());

						/* Interest Calculation */

						LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
						LocalDate toDate = convertToLocalDate(calendar.getTime());
						long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

						installment1.setInterestAmount(
								interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

						calendarFromDate.add(Calendar.MONTH, 1);

					} else if (i % 6 == 0 && i != 0) {
						principal = product;

						interest = dailyInterest;

						principal = product.subtract(installmentAmount);

						installment1.setPrincipalAmount(installmentAmount);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(regular);
						product = principal;

						installment1.setInstallmentFromDate(calendarFromDate.getTime());
						calendar.add(Calendar.MONTH, 1);
						installment1.setInstallmentDate(calendar.getTime());

						/* Interest Calculation */

						LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
						LocalDate toDate = convertToLocalDate(calendar.getTime());
						long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

						installment1.setInterestAmount(
								interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

						calendarFromDate.add(Calendar.MONTH, 1);

					} else {

						principal = product;

						interest = dailyInterest;

						installment1.setPrincipalAmount(BigDecimal.ZERO);
						installment1.setPrincipalAmountOutstanding(principal);
						installment1.setInstallmentDescription(interestDemand);

						installment1.setInstallmentFromDate(calendarFromDate.getTime());
						calendar.add(Calendar.MONTH, 1);
						installment1.setInstallmentDate(calendar.getTime());

						/* Interest Calculation */

						LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
						LocalDate toDate = convertToLocalDate(calendar.getTime());
						long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

						installment1.setInterestAmount(
								interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

						calendarFromDate.add(Calendar.MONTH, 1);

					}

					principalTable.add(installment1);
				}

			}

		}
		return principalTable;
	}

	/* calculate payment schedule as per maturity (Praveen) */

	public List<TestPrincipalCalculation> calculatePrincialPaymentNoticeAtMaturity(Date creationDate,
			Date installmentStartDate, Date installmentEndDate, BigDecimal productValue, BigDecimal product,
			String insterestFrequency, BigDecimal interestPercentage, int numberOfInstallments,
			BigDecimal installmentAmount) {

		String rateCode = "LIN5%";
		String interestDemand = "INTEREST DEMAND";
		String regular = "REGULAR INSTALLMENT";

		List<TestPrincipalCalculation> principalTable = new ArrayList<>();
		BigDecimal principal;
		System.out.println("installment percentage : " + interestPercentage);
		BigDecimal monthlyInterestRate = interestPercentage.divide(BigDecimal.valueOf(100), 4,
				BigDecimal.ROUND_HALF_UP);

		BigDecimal dailyInterest = product.multiply(interestPercentage)
				.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)
				.divide(new BigDecimal(30), 2, RoundingMode.HALF_UP);

		System.out.println("Monthly Interest : " + monthlyInterestRate);
		System.out.println("Daily Interest : " + dailyInterest);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(creationDate);

		Calendar calendarFromDate = Calendar.getInstance();
		calendarFromDate.setTime(creationDate);

		LocalDate startDate = convertToLocalDate(creationDate);
		LocalDate endDate = convertToLocalDate(installmentEndDate);
		long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);

		int noOfMonths = (int) monthsBetween;

		for (int i = 1; i <= noOfMonths; i++) {

			TestPrincipalCalculation installment1 = new TestPrincipalCalculation();

			if ("Monthly".equalsIgnoreCase(insterestFrequency)) {

				/* principal - At Maturity and interest - Monthly */
				installment1.setProduct(product);
				installment1.setProductValue(productValue);
				installment1.setInstallmentFrequency(insterestFrequency);
				installment1.setInterestPercentage(interestPercentage);

				installment1.setRateCode(rateCode);
				installment1.setPrincipalOverDue(BigDecimal.ZERO);
				installment1.setInterestOverdue(BigDecimal.ZERO);
				installment1.setInstallmentFromDate(calendarFromDate.getTime());

				BigDecimal interest = BigDecimal.ZERO;
				if (i == 0) {
					principal = product;

					interest = dailyInterest;

					installment1.setPrincipalAmount(BigDecimal.ZERO);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(interestDemand);

					calendar.add(Calendar.MONTH, 1);
					installment1.setInstallmentDate(calendar.getTime());

					/* Interest Calculation */

					LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
					LocalDate toDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

					installment1.setInterestAmount(
							interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

					calendarFromDate.add(Calendar.MONTH, 1);

				} else if (i == noOfMonths) {
					principal = product;
					interest = dailyInterest;

					installment1.setPrincipalAmount(principal);
					principal = product.subtract(principal);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(regular);

					calendar.add(Calendar.MONTH, 1);
					installment1.setInstallmentDate(calendar.getTime());

					/* Interest Calculation */

					LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
					LocalDate toDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

					installment1.setInterestAmount(
							interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

					calendarFromDate.add(Calendar.MONTH, 1);

				} else {
					principal = product;
					interest = dailyInterest;

					installment1.setPrincipalAmount(BigDecimal.ZERO);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(interestDemand);

					calendar.add(Calendar.MONTH, 1);
					installment1.setInstallmentDate(calendar.getTime());

					/* Interest Calculation */

					LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
					LocalDate toDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

					installment1.setInterestAmount(
							interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

					calendarFromDate.add(Calendar.MONTH, 1);

				}

			} else if ("Quarterly".equalsIgnoreCase(insterestFrequency)) {

				/* principal - At Maturity and interest - Quarterly */

				installment1.setProduct(product);
				installment1.setProductValue(productValue);
				installment1.setInstallmentFrequency(insterestFrequency);
				installment1.setInterestPercentage(interestPercentage);
				installment1.setRateCode(rateCode);
				installment1.setPrincipalOverDue(BigDecimal.ZERO);
				installment1.setInterestOverdue(BigDecimal.ZERO);

				BigDecimal interest = BigDecimal.ZERO;

				if (i == 0) {
					principal = product;

					LocalDate monthEndDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(startDate, monthEndDate);
					System.out.println("Days Between : " + daysBetween);

					LocalDate monthEndDay = monthEndDate.with(TemporalAdjusters.lastDayOfMonth());
					int daysInMonth = monthEndDay.lengthOfMonth();

					interest = principal.multiply(monthlyInterestRate);

					long interestValue = interest.longValue() * daysBetween / daysInMonth;

					installment1.setInterestAmount(BigDecimal.valueOf(interestValue));
					installment1.setPrincipalAmount(BigDecimal.ZERO);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(interestDemand);

				} else if (i % 3 == 0 && i != 0 && i != noOfMonths) {
					principal = product;
					interest = dailyInterest;

					installment1.setPrincipalAmount(BigDecimal.ZERO);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(interestDemand);

					// from date
					installment1.setInstallmentFromDate(calendarFromDate.getTime());
					// demand date
					calendar.add(Calendar.MONTH, 3);
					installment1.setInstallmentDate(calendar.getTime());

					/* Interest Calculation */

					LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
					LocalDate toDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

					installment1.setInterestAmount(
							interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

					product = principal;

					calendarFromDate.add(Calendar.MONTH, 3);

				} else if (i == noOfMonths) {

					principal = product;
					interest = dailyInterest;

					installment1.setPrincipalAmount(principal);
					principal = product.subtract(principal);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(regular);

					// from date
					installment1.setInstallmentFromDate(calendarFromDate.getTime());
					// demand date
					calendar.add(Calendar.MONTH, 3);
					installment1.setInstallmentDate(calendar.getTime());

					/* Interest Calculation */

					LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
					LocalDate toDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

					installment1.setInterestAmount(
							interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

					product = principal;

				} else {

					principal = product;

					interest = principal.multiply(monthlyInterestRate);
					installment1.setInterestAmount(interest.setScale(2, RoundingMode.CEILING));

					installment1.setPrincipalAmount(BigDecimal.ZERO);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(interestDemand);
				}

			} else if ("Halfyearly".equalsIgnoreCase(insterestFrequency)) {

				/* principal - At Maturity and interest - Half yearly */

				installment1.setProduct(product);
				installment1.setProductValue(productValue);
				installment1.setInstallmentFrequency(insterestFrequency);
				installment1.setInterestPercentage(interestPercentage);
				installment1.setRateCode(rateCode);
				installment1.setPrincipalOverDue(BigDecimal.ZERO);
				installment1.setInterestOverdue(BigDecimal.ZERO);

				BigDecimal interest = BigDecimal.ZERO;

				if (i == 0) {
					principal = product;

					LocalDate monthEndDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(startDate, monthEndDate);
					System.out.println("Days Between : " + daysBetween);

					LocalDate monthEndDay = monthEndDate.with(TemporalAdjusters.lastDayOfMonth());
					int daysInMonth = monthEndDay.lengthOfMonth();

					interest = principal.multiply(monthlyInterestRate);

					long interestValue = interest.longValue() * daysBetween / daysInMonth;

					installment1.setInterestAmount(BigDecimal.valueOf(interestValue));
					installment1.setPrincipalAmount(BigDecimal.ZERO);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(interestDemand);

				} else if (i % 6 == 0 && i != 0 && i != noOfMonths) {
					principal = product;

					interest = dailyInterest;

					installment1.setPrincipalAmount(BigDecimal.ZERO);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(interestDemand);

					// from date
					installment1.setInstallmentFromDate(calendarFromDate.getTime());
					// demand date
					calendar.add(Calendar.MONTH, 6);
					installment1.setInstallmentDate(calendar.getTime());

					/* Interest Calculation */

					LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
					LocalDate toDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

					installment1.setInterestAmount(
							interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

					product = principal;

					calendarFromDate.add(Calendar.MONTH, 6);

				} else if (i == noOfMonths) {

					principal = product;

					interest = dailyInterest;

					installment1.setPrincipalAmount(principal);
					principal = product.subtract(principal);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(regular);

					// from date
					installment1.setInstallmentFromDate(calendarFromDate.getTime());
					// demand date
					calendar.add(Calendar.MONTH, 6);
					installment1.setInstallmentDate(calendar.getTime());

					/* Interest Calculation */

					LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
					LocalDate toDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

					installment1.setInterestAmount(
							interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

					product = principal;

				} else {

					principal = product;

					interest = principal.multiply(monthlyInterestRate);
					installment1.setInterestAmount(interest.setScale(2, RoundingMode.CEILING));

					installment1.setPrincipalAmount(BigDecimal.ZERO);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(interestDemand);
				}
			} else {

				/* principal - At Maturity and interest - yearly */

				installment1.setProduct(product);
				installment1.setProductValue(productValue);
				installment1.setInstallmentFrequency(insterestFrequency);
				installment1.setInterestPercentage(interestPercentage);
				installment1.setRateCode(rateCode);
				installment1.setPrincipalOverDue(BigDecimal.ZERO);
				installment1.setInterestOverdue(BigDecimal.ZERO);

				BigDecimal interest = BigDecimal.ZERO;

				if (i == 0) {
					principal = product;

					LocalDate monthEndDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(startDate, monthEndDate);
					System.out.println("Days Between : " + daysBetween);

					LocalDate monthEndDay = monthEndDate.with(TemporalAdjusters.lastDayOfMonth());
					int daysInMonth = monthEndDay.lengthOfMonth();

					interest = principal.multiply(monthlyInterestRate);

					long interestValue = interest.longValue() * daysBetween / daysInMonth;

					installment1.setInterestAmount(BigDecimal.valueOf(interestValue));
					installment1.setPrincipalAmount(BigDecimal.ZERO);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(interestDemand);

				} else if (i % 12 == 0 && i != 0 && i != noOfMonths) {
					principal = product;

					interest = dailyInterest;

					installment1.setPrincipalAmount(BigDecimal.ZERO);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(interestDemand);

					// from date
					installment1.setInstallmentFromDate(calendarFromDate.getTime());
					// demand date
					calendar.add(Calendar.MONTH, 12);
					installment1.setInstallmentDate(calendar.getTime());

					/* Interest Calculation */

					LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
					LocalDate toDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

					installment1.setInterestAmount(
							interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

					product = principal;

					calendarFromDate.add(Calendar.MONTH, 12);

				} else if (i == noOfMonths) {

					principal = product;

					interest = dailyInterest;

					installment1.setPrincipalAmount(principal);
					principal = product.subtract(principal);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(regular);

					// from date
					installment1.setInstallmentFromDate(calendarFromDate.getTime());

					// demand date
					calendar.add(Calendar.MONTH, 12);
					installment1.setInstallmentDate(calendar.getTime());

					/* Interest Calculation */

					LocalDate fromDate = convertToLocalDate(calendarFromDate.getTime());
					LocalDate toDate = convertToLocalDate(calendar.getTime());
					long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);

					installment1.setInterestAmount(
							interest.multiply(BigDecimal.valueOf(daysBetween)).setScale(2, RoundingMode.CEILING));

					product = principal;

				} else {

					principal = product;

					interest = principal.multiply(monthlyInterestRate);
					installment1.setInterestAmount(interest.setScale(2, RoundingMode.CEILING));

					installment1.setPrincipalAmount(BigDecimal.ZERO);
					installment1.setPrincipalAmountOutstanding(principal);
					installment1.setInstallmentDescription(interestDemand);
				}
			}

			if ("Monthly".equalsIgnoreCase(insterestFrequency)) {
				principalTable.add(installment1);
			} else if ("Quarterly".equalsIgnoreCase(insterestFrequency)) {
				if (i % 3 == 0 && i != 0) {
					principalTable.add(installment1);
				}
			} else if ("Halfyearly".equalsIgnoreCase(insterestFrequency)) {
				if (i % 6 == 0 && i != 0) {
					principalTable.add(installment1);
				}
			} else {
				if (i % 12 == 0 && i != 0) {
					principalTable.add(installment1);
				}
			}

		}
		return principalTable;
	}

	private static LocalDate convertToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public BigDecimal getInterestAmount(BigDecimal installmentAmount, BigDecimal per) {
		BigDecimal interestAmount;
		if (installmentAmount != null && installmentAmount.compareTo(BigDecimal.ZERO) == 0) {
			interestAmount = installmentAmount;
		} else {
			interestAmount = installmentAmount.multiply(per.divide(BigDecimal.valueOf(100)));
		}
		return interestAmount;
	}

	// @Scheduled(cron = "*/20 * * ? * *")
	public void PercentageCalculationExamplexx() {
		BigDecimal totalAmount = new BigDecimal("1000");
		BigDecimal interestRate = new BigDecimal("5");
		BigDecimal interestAmount = totalAmount.multiply(interestRate.divide(BigDecimal.valueOf(100)));
		System.out.println("Total Amount: " + totalAmount);
		System.out.println("Interest Rate: " + interestRate + "%");
		System.out.println("Interest Amount: " + interestAmount);
	}

}
