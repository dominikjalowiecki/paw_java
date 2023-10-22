package com.jsfcourse.calc;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
public class CreditBB {
	private Integer amount;
	private Integer duration;
	private Double interestRate;
	private Double result;

	@Inject
	FacesContext ctx;
	

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Double getResult() {
		return result;
	}
	
	private boolean process() {		
		try {
			result = (amount + amount * interestRate / 100) / duration;
			
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operation ended successfully", null));
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error during processing of parameters", null));
			return false;
		}
		return true;
	}

	public String calculate() {
		if(process()) {
			return "result";
		}
		return null;
	}
	
	public String calculateAjax() {
		if(process()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Result: " + result, null));
		}
		return null;
	}
}
