package com.bornfire.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bornfire.entities.DepositEntity;
import com.bornfire.entities.DepositRep;
import com.bornfire.entities.Td_defn_Repo;
import com.bornfire.entities.Td_defn_table;

@Service
public class DepositServices {

	@Autowired
	DepositRep depositRep;

	@Autowired
	Td_defn_Repo td_defn_Repo;

	public String deposit(Td_defn_table td_defn_table, DepositEntity depositEntity) {

		 
			/* Deposit save */
			System.out.println("deposit");
			depositEntity.setEntity_flg("N");
			depositEntity.setModify_flg("Y");
			depositEntity.setDel_flg("N");

			depositRep.save(depositEntity);

			/* flow code starts */
			String depotype = depositEntity.getDeposit_type();

			if (depotype.equals("Fixed")) {
				BigDecimal previousBalance = BigDecimal.ZERO;
			    BigDecimal flowAmount1;
			    BigDecimal flowAmount2;
			    BigDecimal balance1 = BigDecimal.ZERO;
			    BigDecimal balance2 = BigDecimal.ZERO;
			    Td_defn_table lastTdDefnTable;

			    String depositPeriodStr = depositEntity.getDeposit_period();
			    BigDecimal depositPeriod = new BigDecimal(depositPeriodStr);
			    BigDecimal one = BigDecimal.ONE;
			    System.out.println("Deposit Period: " + depositPeriod);

			    String frequency = depositEntity.getFrequency();
			    Date depositDate = depositEntity.getDeposit_date();
			    System.out.println(depositDate + " maturityDate");

			    String rateString = depositEntity.getRate_of_int();
			    BigDecimal rate = new BigDecimal(rateString);

			    int scale = 2; // Set to 2 for two decimal places
			    BigDecimal percentageRate = rate.divide(BigDecimal.valueOf(100), scale, RoundingMode.DOWN);
			    
			    Date lastIoDepositDate = null;
				BigDecimal rowCount = depositPeriod.add(new BigDecimal("2"));
				
				for (BigDecimal i = BigDecimal.ONE; i.compareTo(rowCount) <= 0; i = i.add(one)) {
					System.out.println(depositPeriod +"depositPeriod");
					Td_defn_table newTdDefnTable = new Td_defn_table();

					newTdDefnTable.setAcid(depositEntity.getDepo_actno());
					newTdDefnTable.setFlow_date(depositDate);
					
					BigDecimal flowAmount = previousBalance.equals(BigDecimal.ZERO) ? depositEntity.getDeposit_amt() : previousBalance;
			        System.out.println(flowAmount + " flowAmount");

					if (i.equals(BigDecimal.ONE)) {
						// First row
						newTdDefnTable.setFlow_code("PI");
						newTdDefnTable.setFlow_amt(flowAmount);
						newTdDefnTable.setClr_bal_amt(flowAmount);
					} else if (i.equals(rowCount)) {
						
						//LAST ROW
						newTdDefnTable.setFlow_code("PO");
			            depositDate = lastIoDepositDate;
			            if (frequency.equals("Monthly")) {
			                flowAmount1 = flowAmount.multiply(percentageRate)
			                        .divide(BigDecimal.valueOf(12), scale, RoundingMode.DOWN)
			                        .setScale(2, RoundingMode.DOWN);
			                balance1 = flowAmount.add(flowAmount1);
			               

			                newTdDefnTable.setFlow_amt(balance1);
			            }else {
			                flowAmount2 = flowAmount.multiply(percentageRate)
			                        .setScale(2, RoundingMode.DOWN);
			               
			                balance2 = flowAmount.add(flowAmount2);
			                newTdDefnTable.setFlow_amt(balance2);
			                

			                System.out.println("amt2: " + flowAmount2);
			            }
			            newTdDefnTable.setClr_bal_amt(BigDecimal.ZERO);

					} else {
						// Middle rows
						newTdDefnTable.setFlow_code("IO");
						 if (frequency.equals("Monthly")) {
				                flowAmount1 = flowAmount.multiply(percentageRate)
				                        .divide(BigDecimal.valueOf(12), scale, RoundingMode.DOWN)
				                        .setScale(2, RoundingMode.DOWN);
				                balance1 = flowAmount.add(flowAmount1);

				                newTdDefnTable.setFlow_amt(flowAmount1);
				                newTdDefnTable.setClr_bal_amt(flowAmount);

				                System.out.println("amt1: " + flowAmount);
				                lastIoDepositDate = depositDate;
				            } else {
				                flowAmount2 = flowAmount.multiply(percentageRate)
				                        .setScale(2, RoundingMode.DOWN);
				                balance2 = flowAmount.add(flowAmount2);

				                newTdDefnTable.setFlow_amt(flowAmount2);
				                newTdDefnTable.setClr_bal_amt(balance2);

				                System.out.println("amt2: " + flowAmount);
				                System.out.println("bal2: " + flowAmount);
				            }
						
						
						
					}
					
					newTdDefnTable.setFlow_date(depositDate);

					/* for srl no and flowid */
					String notifyRef = td_defn_Repo.getTranNo();
					int NotifyReference;
					if (notifyRef != null) {
						NotifyReference = Integer.valueOf(notifyRef) + 1;
					} else {
						NotifyReference = 1;
					}
					newTdDefnTable.setSrl_no(BigDecimal.valueOf(NotifyReference));
					newTdDefnTable.setFlow_id(i);

					System.out.println(NotifyReference);
					System.out.println("Row " + i + ":");
					System.out.println("ACID: " + depositEntity.getDepo_actno());
					System.out.println("Flow Code: PI");
					System.out.println("Flow Date: " + depositDate);
					System.out.println("Flow Amount: " + flowAmount);

					td_defn_Repo.save(newTdDefnTable);

					if (!i.equals(rowCount) && !i.equals(rowCount.add(one))) {
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(depositDate);
						if (frequency.equals("Monthly")) {
							calendar.add(Calendar.MONTH, 1);
						} else {
							calendar.add(Calendar.YEAR, 1);
						}
						depositDate = calendar.getTime();
					}
				}
			}

			else if (depotype.equals("Reinvestment")) {
			    BigDecimal previousBalance = BigDecimal.ZERO;
			    BigDecimal flowAmount1;
			    BigDecimal flowAmount2;
			    BigDecimal balance1 = BigDecimal.ZERO;
			    BigDecimal balance2 = BigDecimal.ZERO;
			    BigDecimal addamt1 = BigDecimal.ZERO;
			    BigDecimal addamt2 = BigDecimal.ZERO;
			    Td_defn_table lastTdDefnTable;

			    String depositPeriodStr = depositEntity.getDeposit_period();
			    BigDecimal depositPeriod = new BigDecimal(depositPeriodStr);
			    BigDecimal one = BigDecimal.ONE;
			    System.out.println("Deposit Period: " + depositPeriod);

			    String frequency = depositEntity.getFrequency();
			    Date depositDate = depositEntity.getDeposit_date();
			    System.out.println(depositDate + " maturityDate");

			    String rateString = depositEntity.getRate_of_int();
			    BigDecimal rate = new BigDecimal(rateString);

			    int scale = 2; // Set to 2 for two decimal places
			    BigDecimal percentageRate = rate.divide(BigDecimal.valueOf(100), scale, RoundingMode.DOWN);
			    
			    Date lastIoDepositDate = null;
				BigDecimal rowCount = depositPeriod.add(new BigDecimal("2"));

			    // Loop through each period
			    for (BigDecimal i = BigDecimal.ONE; i.compareTo(rowCount) <= 0; i = i.add(one)) {
			        Td_defn_table newTdDefnTable = new Td_defn_table();

			        newTdDefnTable.setAcid(depositEntity.getDepo_actno());
			        newTdDefnTable.setFlow_date(depositDate);
			        
			        // lastTdDefnTable contains the last row date
			        if (i.compareTo(depositPeriod) == 0) {
			            lastTdDefnTable = newTdDefnTable;
			            depositEntity.setMaturity_date(lastTdDefnTable.getFlow_date());
			        }


			        BigDecimal flowAmount = previousBalance.equals(BigDecimal.ZERO) ? depositEntity.getDeposit_amt() : previousBalance;

			        if (i.equals(BigDecimal.ONE)) {
			            // First row
			            newTdDefnTable.setFlow_code("PI");
			            newTdDefnTable.setFlow_amt(flowAmount);
			            newTdDefnTable.setClr_bal_amt(flowAmount);
			        } else if (i.equals(rowCount)) {
			            // Last row
			            newTdDefnTable.setFlow_code("TO");
			            depositDate = lastIoDepositDate;
			            if (frequency.equals("Monthly")) {
			                flowAmount1 = flowAmount.multiply(percentageRate)
			                        .divide(BigDecimal.valueOf(12), scale, RoundingMode.DOWN)
			                        .setScale(2, RoundingMode.DOWN);
			                //addamt1 = flowAmount.add(flowAmount1);
			               

			                newTdDefnTable.setFlow_amt(previousBalance);
			            }else {
			                flowAmount2 = flowAmount.multiply(percentageRate)
			                        .setScale(2, RoundingMode.DOWN);
			               
			                //addamt2 = flowAmount.add(flowAmount2);
			                newTdDefnTable.setFlow_amt(previousBalance);

			                System.out.println("amt2: " + flowAmount2);
			            }
			            newTdDefnTable.setClr_bal_amt(BigDecimal.ZERO);
			        } else{
			            // Middle rows (starting from the 2nd row)
			            newTdDefnTable.setFlow_code("II");

			            if (frequency.equals("Monthly")) {
			                flowAmount1 = flowAmount.multiply(percentageRate)
			                        .divide(BigDecimal.valueOf(12), scale, RoundingMode.DOWN)
			                        .setScale(2, RoundingMode.DOWN);
			                balance1 = flowAmount.add(flowAmount1);

			                newTdDefnTable.setFlow_amt(flowAmount1);
			                newTdDefnTable.setClr_bal_amt(balance1);

			                System.out.println("amt1: " + flowAmount1);
			                previousBalance = balance1;
			                lastIoDepositDate = depositDate;
			            } else {
			                flowAmount2 = flowAmount.multiply(percentageRate)
			                        .setScale(2, RoundingMode.DOWN);
			                balance2 = flowAmount.add(flowAmount2);

			                newTdDefnTable.setFlow_amt(flowAmount2);
			                newTdDefnTable.setClr_bal_amt(balance2);

			                System.out.println("amt2: " + flowAmount2);
			                System.out.println("bal2: " + balance2);
			                previousBalance = balance1;
			            }
			        }
			        
			        newTdDefnTable.setFlow_date(depositDate);

			        // For serial number and flow ID
			        String notifyRef = td_defn_Repo.getTranNo();
			        int notifyReference = (notifyRef != null) ? Integer.parseInt(notifyRef) + 1 : 1;

			        newTdDefnTable.setSrl_no(BigDecimal.valueOf(notifyReference));
			        newTdDefnTable.setFlow_id(i);

			        System.out.println("Notify Reference: " + notifyReference);
			        System.out.println("Row " + i + ":");
			        System.out.println("ACID: " + depositEntity.getDepo_actno());
			        System.out.println("Flow Code: " + newTdDefnTable.getFlow_code());
			        System.out.println("Flow Date: " + depositDate);
			        System.out.println("Flow Amount: " + newTdDefnTable.getFlow_amt());

			        td_defn_Repo.save(newTdDefnTable);
			        
			        // Update maturity date and previous balance based on frequency
			        if (!i.equals(rowCount) && !i.equals(rowCount.add(one))) {
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(depositDate);
						if (frequency.equals("Monthly")) {
							calendar.add(Calendar.MONTH, 1);
						} else {
							calendar.add(Calendar.YEAR, 1);
						}
						depositDate = calendar.getTime();
					}
			    }
			}


			return "Sucessfully Saved";
		

	}
}
