package model;

public class Level2Bot implements BotAbstractFactory{

	@Override
	public P4Player create() {
		return new OpponentBot(new RandomBot());
	}

}
