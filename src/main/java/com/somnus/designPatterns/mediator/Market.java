package com.somnus.designPatterns.mediator;

public class Market implements Department{
	/*持有中介者的引用*/
	private Mediator mediator;
	
	public Market(Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.register("market", this);
	}

	@Override
	public void selfAction() {
		// TODO Auto-generated method stub
		System.out.println("接项目");
	}

	@Override
	public void outAction() {
		// TODO Auto-generated method stub
		System.out.println("汇报工作：需要资金支持");
		mediator.command("finacial");
	}

}
