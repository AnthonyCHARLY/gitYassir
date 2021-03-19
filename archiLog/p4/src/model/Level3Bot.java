package model;

public class Level3Bot implements BotAbstractFactory{

	@Override
	public P4Player create() {
		return new DirectWinBot(new OpponentBot(new RandomBot()));
	}

}
