package components.shotting.strategies;


import components.Ship;
import components.shotting.Shot;
import scenes.SpaceScene;

public class TripleShot implements ShotStrategy{
	@Override
	public void shot(SpaceScene scene, Ship ship) {
		Shot left = ship.createShot();
		Shot center = ship.createShot();
		Shot right = ship.createShot();

		left.setX(ship.getX());
		left.setY(ship.getY() + (ship.getHeight()/2));

		right.setX(ship.getX() + ship.getWidth() - right.getWidth());
		right.setY(ship.getY() + (ship.getHeight()/2));

		scene.shot(left);
		scene.shot(center);
		scene.shot(right);
	}
}
