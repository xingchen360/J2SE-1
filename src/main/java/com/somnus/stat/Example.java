package com.somnus.stat;

import java.math.BigDecimal;

public class Example extends Base{
	private BigDecimal value;
	
	private BigDecimal value2;
	
	private BigDecimal value3;
	
	public Example(){
		this.value = BigDecimal.ZERO;
		this.value2 = BigDecimal.ZERO;
		this.value3 = BigDecimal.ZERO;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue2() {
		return value2;
	}

	public void setValue2(BigDecimal value2) {
		this.value2 = value2;
	}

	public BigDecimal getValue3() {
		return value3;
	}

	public void setValue3(BigDecimal value3) {
		this.value3 = value3;
	}
	
}
