package components.states;


import com.uqbar.vainilla.appearances.Appearance;
import components.Collidable;
import components.Ship;

public class LastLifeState implements ShipState {

	private Appearance appearance;

	public LastLifeState(Appearance appearance) {
		setAppearance(appearance);
	}

	@Override
	public void collidedBy(Ship ship, Collidable collidable) {
		ship.destroy();
	}

	@Override
	public Appearance getAppearance() {
		return this.appearance;
	}

	@Override
	public int getLifePoints() {
		return 1;
	}

	public void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}

}
