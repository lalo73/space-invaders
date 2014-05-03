package components.shotting.strategies;


import components.Ship;
import scenes.SpaceScene;

public interface ShotStrategy {

	public void shot(SpaceScene scene, Ship ship);
}
