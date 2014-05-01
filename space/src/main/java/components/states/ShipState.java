package components.states;


import com.uqbar.vainilla.appearances.Appearance;
import components.Collidable;
import components.Ship;

public interface ShipState {

	public void collidedBy(Ship ship, Collidable collidable);

	public Appearance getAppearance();

	public int getLifePoints();
}
