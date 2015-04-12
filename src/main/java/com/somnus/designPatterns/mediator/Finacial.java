package com.somnus.designPatterns.mediator;

public class Finacial implements Department{
	/*持有中介者的引用*/
	private Mediator mediator;
	
	public Finacial(Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.register("finacial", this);
	}

	@Override
	public void selfAction() {
		// TODO Auto-generated method stub
		System.out.println("数钱");
	}

	@Override
	public void outAction() {
		// TODO Auto-generated method stub
		System.out.println("汇报工作：钱太多了，怎么花");
	}

}
