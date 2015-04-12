package com.somnus.designPatterns.command;
/**
 * 调用者、发起者
 * @author Smile
 *
 */
public class Invoke {
	private Command command;

	public Invoke(Command command) {
		super();
		this.command = command;
	}
	/*业务方法，用于调用命令的方法*/
	public void call(){
		command.execute();
	}
}
