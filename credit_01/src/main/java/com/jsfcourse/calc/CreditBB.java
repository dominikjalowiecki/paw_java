package com.jsfcourse.calc;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
public class CreditBB {
	private String amount;
	private String duration;
	private String interestRate;
	private Double result;

	@Inject
	FacesContext ctx;
	

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public Double getResult() {
		return result;
	}

	public String calculate() {
		try {
			double amount = Double.parseDouble(this.amount);
			int duration = Integer.parseInt(this.duration);
			double interestRate = Double.parseDouble(this.interestRate);
	
			result = (amount + amount * interestRate / 100) / duration;
	
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation ended successfully", null));
			} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error during processing of parameters", null));
		}
		
		return null;
	}
}
