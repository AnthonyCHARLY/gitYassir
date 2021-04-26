package model;

public class Level1Bot implements BotAbstractFactory{

	@Override
	public P4Player create() {
		return new RandomBot();
	}

}
