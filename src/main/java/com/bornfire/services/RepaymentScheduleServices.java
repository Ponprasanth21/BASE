package com.bornfire.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.stereotype.Service;

import com.bornfire.entities.RepaymentScheduleEntity;
import com.ibm.icu.text.SimpleDateFormat;

@Service
@ConfigurationProperties("output")
@Transactional
public class RepaymentScheduleServices {

	// @Scheduled(cron = "0 * * ? * *")

	// @Scheduled(cron = "0 */30 * ? * *")
	public List<RepaymentScheduleEntity> calculateRepay() throws ParseException {
		double principalAmount = 1000.0;
		String amtSpecific = "Fixed";
		// String installmentFrequency = "MONTHLY";
		// String installmentFrequency = "QUARTERLY";
		// String installmentFrequency = "HALFYEARLY";
		String installmentFrequency = "YEARLY";
		int numberOfInstallments = 12;
		int inst_id = 1;

		String sampleDateString = "05-03-2024";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Date installmentStartDate = dateFormat.parse(sampleDateString);
		double installmentPer = 5.0;
		double installmentAmount = 100.0;
		List<RepaymentScheduleEntity> repaymentSchedule = calculateRepaymentSchedule(principalAmount, amtSpecific,
				installmentFrequency, numberOfInstallments, installmentStartDate, installmentPer, installmentAmount,
				inst_id);

		for (RepaymentScheduleEntity entry : repaymentSchedule) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String orgDate = sdf.format(entry.getOriginalDemandDate());
			String demDate = sdf.format(entry.getDemandDate());
			System.out.println("scheduleNo: " + entry.getScheduleNo() + "||" + "originalDemandDate: " + orgDate + "||"
					+ "demandDate: " + demDate + "||" + "demandType: " + entry.getDemandType() + "||" + "demandId: "
					+ entry.getDemandId() + "||" + "demandAmount: " + entry.getDemandAmount() + "||" + "installmentNo: "
					+ entry.getInstallmentNo() + "||" + "Remarks: " + entry.getRemarks());
		}

		return repaymentSchedule;
	}

	public List<RepaymentScheduleEntity> calculateRepaymentSchedule(double productAmount, String amtSpecific,
			String installmentFrequency, int numberOfInstallments, Date installmentStartDate, double installmentPer,
			double principleAmount, int inst_Id) {
		List<RepaymentScheduleEntity> repaymentSchedule = new ArrayList<>();
		for (int i = 1; i <= numberOfInstallments; i++) {
			RepaymentScheduleEntity entry = new RepaymentScheduleEntity();
			entry.setScheduleNo(inst_Id);
			entry.setDemandType("P");
			entry.setDemandId("PRDEM");
			entry.setInstallmentNo(i);
			entry.setRemarks("");
			entry.setDemandAmount(
					calculateDemandAmount(amtSpecific, installmentPer, numberOfInstallments, productAmount));

			// Determine demand date based on frequency
			Date originalDemandDate = installmentStartDate;
			Date demandDate = calculateDemandDate(installmentFrequency, originalDemandDate, i);

			entry.setOriginalDemandDate(demandDate);
			entry.setDemandDate(demandDate);

			repaymentSchedule.add(entry);

			// Calculate the next installment start date
			installmentStartDate = demandDate;
		}

		return repaymentSchedule;
	}

	public List<RepaymentScheduleEntity> calculateRepaymentScheduleAtMaturity(double productAmount, String amtSpecific,
			String installmentFrequency, int numberOfInstallments, Date installmentStartDate, double installmentPer,
			double principleAmount, int inst_Id) {
		List<RepaymentScheduleEntity> repaymentSchedule = new ArrayList<>();
		for (int i = 1; i <= numberOfInstallments; i++) {
			RepaymentScheduleEntity entry = new RepaymentScheduleEntity();

			if (i == numberOfInstallments) {
				entry.setScheduleNo(inst_Id);
				entry.setDemandType("P");
				entry.setDemandId("PRDEM");
				entry.setInstallmentNo(i);
				entry.setRemarks("");
				entry.setDemandAmount(productAmount);

				// Determine demand date based on frequency
				Date originalDemandDate = installmentStartDate;
				Date demandDate = calculateDemandDate(installmentFrequency, originalDemandDate, i);

				entry.setOriginalDemandDate(demandDate);
				entry.setDemandDate(demandDate);
				// installmentStartDate = demandDate;

			} else {
				entry.setScheduleNo(inst_Id);
				entry.setDemandType("P");
				entry.setDemandId("PRDEM");
				entry.setInstallmentNo(i);
				entry.setRemarks("");
				entry.setDemandAmount(0.0d);

				// Determine demand date based on frequency
				Date originalDemandDate = installmentStartDate;
				Date demandDate = calculateDemandDate(installmentFrequency, originalDemandDate, i);

				entry.setOriginalDemandDate(demandDate);
				entry.setDemandDate(demandDate);
				installmentStartDate = demandDate;
			}

			repaymentSchedule.add(entry);

			// Calculate the next installment start date

		}

		return repaymentSchedule;
	}

	private double calculateDemandAmount(String amtSpecific, double installmentPer, int numberOfInstallments,
			double productAmount) {
		return "Fixed".equals(amtSpecific) ? (productAmount / numberOfInstallments)
				: (productAmount * installmentPer / 100);
	}

	private Date calculateDemandDate(String installmentFrequency, Date originalDemandDate, int i) {

		// all months show
		/*
		 * Calendar calendar = Calendar.getInstance();
		 * calendar.setTime(originalDemandDate); if (i == 1) {
		 * calendar.add(Calendar.MONTH, 1); calendar.set(Calendar.DAY_OF_MONTH, 1);
		 * calendar.add(Calendar.DAY_OF_MONTH, -1); } else {
		 * calendar.add(Calendar.MONTH, 2); calendar.set(Calendar.DAY_OF_MONTH, 1);
		 * calendar.add(Calendar.DAY_OF_MONTH, -1); }
		 */

		// only frequency months show

		Calendar calendar = Calendar.getInstance();
		if ("Monthly".equals(installmentFrequency)) {

			calendar.setTime(originalDemandDate);
			calendar.add(Calendar.MONTH, 1);
			/*
			 * if (i == 1) {
			 * 
			 * calendar.add(Calendar.MONTH, 1); calendar.set(Calendar.DAY_OF_MONTH, 1);
			 * calendar.add(Calendar.DAY_OF_MONTH, -1); } else {
			 * calendar.add(Calendar.MONTH, 2); calendar.set(Calendar.DAY_OF_MONTH, 1);
			 * calendar.add(Calendar.DAY_OF_MONTH, -1); }
			 */

			// return calendar.getTime();
		} else if ("Quarterly".equals(installmentFrequency)) {
			// Calendar calendar = Calendar.getInstance();
			calendar.setTime(originalDemandDate);
			calendar.add(Calendar.MONTH, 3);

			/*
			 * if (i == 1) {
			 * 
			 * calendar.add(Calendar.MONTH, 3); calendar.add(Calendar.MONTH, 1);
			 * calendar.set(Calendar.DAY_OF_MONTH, 1); calendar.add(Calendar.DAY_OF_MONTH,
			 * -1); } else { calendar.add(Calendar.MONTH, 4);
			 * calendar.set(Calendar.DAY_OF_MONTH, 1); calendar.add(Calendar.DAY_OF_MONTH,
			 * -1); }
			 */

			// return calendar.getTime();
		} else if ("Halfyearly".equals(installmentFrequency)) {
			// Calendar calendar = Calendar.getInstance();
			calendar.setTime(originalDemandDate);
			calendar.add(Calendar.MONTH, 6);

			/*
			 * if (i == 1) {
			 * 
			 * calendar.add(Calendar.MONTH, 6); calendar.add(Calendar.MONTH, 1);
			 * calendar.set(Calendar.DAY_OF_MONTH, 1); calendar.add(Calendar.DAY_OF_MONTH,
			 * -1); } else { calendar.add(Calendar.MONTH, 7);
			 * calendar.set(Calendar.DAY_OF_MONTH, 1); calendar.add(Calendar.DAY_OF_MONTH,
			 * -1); }
			 */

			// return calendar.getTime();
		} else if ("Yearly".equals(installmentFrequency)) {
			// Calendar calendar = Calendar.getInstance();
			calendar.setTime(originalDemandDate);
			calendar.add(Calendar.MONTH, 12);

			/*
			 * if (i == 1) {
			 * 
			 * calendar.add(Calendar.MONTH, 12); calendar.add(Calendar.MONTH, 1);
			 * calendar.set(Calendar.DAY_OF_MONTH, 1); calendar.add(Calendar.DAY_OF_MONTH,
			 * -1); } else { calendar.add(Calendar.MONTH, 13);
			 * calendar.set(Calendar.DAY_OF_MONTH, 1); calendar.add(Calendar.DAY_OF_MONTH,
			 * -1); }
			 */

		} else if ("Bullet".equals(installmentFrequency)) {
			// Calendar calendar = Calendar.getInstance();
			calendar.setTime(originalDemandDate);
			calendar.add(Calendar.MONTH, 1);

		}

		return calendar.getTime();
	}

}
