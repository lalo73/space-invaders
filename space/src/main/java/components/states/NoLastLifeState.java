package components.states;


import com.uqbar.vainilla.appearances.Appearance;
import components.Collidable;
import components.Ship;

public class NoLastLifeState implements ShipState {
	private ShipState nextShipState;
	private Appearance appearance;

	public NoLastLifeState(ShipState nextShipState, Appearance appearance) {
		setNextShipState(nextShipState);
		setAppearance(appearance);
	}

	@Override
	public void collidedBy(Ship ship, Collidable collidable) {
		ship.setShipState(getNextShipState());
	}

	@Override
	public Appearance getAppearance() {
		return appearance;
	}

	@Override
	public int getLifePoints() {
		return 1 + getNextShipState().getLifePoints();
	}

	public ShipState getNextShipState() {
		return nextShipState;
	}

	public void setNextShipState(ShipState nextShipState) {
		this.nextShipState = nextShipState;
	}

	public void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}
}
