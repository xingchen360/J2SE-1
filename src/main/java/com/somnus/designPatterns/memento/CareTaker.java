package com.somnus.designPatterns.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人类
 * @author Smile
 *
 */
public class CareTaker {
	private EmpMemento empMemento;
	/*可以通过增加容器，设置多个备忘点*/
	private List<EmpMemento> list = new ArrayList<EmpMemento>();

	public EmpMemento getEmpMemento() {
		return empMemento;
	}

	public void setEmpMemento(EmpMemento empMemento) {
		this.empMemento = empMemento;
	}
	
}
