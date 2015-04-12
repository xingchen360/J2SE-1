package com.somnus.designPatterns.mediator;

public class Development implements Department{
	/*持有中介者的引用*/
	private Mediator mediator;
	
	public Development(Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.register("development", this);
	}

	@Override
	public void selfAction() {
		// TODO Auto-generated method stub
		System.out.println("专心研发");
	}

	@Override
	public void outAction() {
		// TODO Auto-generated method stub
		System.out.println("汇报工作：没钱了，需要资金支持");
		mediator.command("finacial");
	}

}
