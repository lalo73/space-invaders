package components.factories;


import components.states.LastLifeState;
import components.states.NoLastLifeState;
import space.SpaceGame;

public class InvaderStateFactory {

	public static NoLastLifeState getStateForColor(SpaceGame game, String color) {
		String lastLife = String.format("%s-2", color);
		LastLifeState lastLifeState = new LastLifeState(game.getResource(lastLife));
		String secondState = String.format("%s-1", color);
		NoLastLifeState noLastLifeState = new NoLastLifeState(lastLifeState, game.getResource(secondState));
		String thridState = String.format("%s", color);
		return new NoLastLifeState(noLastLifeState, game.getResource(thridState));
	}
}
