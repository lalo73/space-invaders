package components.shotting.strategies;


import components.Ship;
import scenes.SpaceScene;

public class SimpleShot implements ShotStrategy{
	@Override
	public void shot(SpaceScene scene, Ship ship) {
		scene.shot(ship.createShot());
	}
}
