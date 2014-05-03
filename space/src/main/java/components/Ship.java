package components;

import collisionGroups.CollisionGroup;
import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.appearances.Invisible;
import components.states.LastLifeState;
import components.states.ShipState;
import components.strategies.ShotStrategy;
import components.strategies.SimpleShot;
import scenes.SpaceScene;

public abstract class Ship extends BasicMovingSpaceComponent implements Collidable, Shooter {
	private int shotPower;
	private CollisionGroup collisionGroup;
	private ShipState shipState;
	private ShotStrategy shotStrategy;

	public Ship() {
		super();
		init();
	}

	public Ship(ShipState shipState, int x, int y, int xV, int yV, int speed) {
		super(x, y, xV, yV, speed);
		setShipState(shipState);
		init();
	}

	public Ship(int x, int y, int xV, int yV, int speed) {
		super(x, y, xV, yV, speed);
		setShipState(new LastLifeState(new Invisible()));
		init();
	}

	public void init() {
		setShotPower(1);
		setShotStrategy(new SimpleShot());
	}

	public int getShotPower() {
		return shotPower;
	}

	@Override
	public Appearance getAppearance() {
		return getShipState().getAppearance();
	}

	public void setShotPower(int shotPower) {
		this.shotPower = shotPower;
	}

	@Override
	public void collidedBy(Collidable collidable) {
		getShipState().collidedBy(this, collidable);
	}

	@Override
	public void destroy() {
		getScene().getCollidables().remove(this);
		super.destroy();
	}

	@Override
	public GameComponent<SpaceScene> asComponent() {
		return this;
	}

	@Override
	public boolean canCollision(Collidable collidable) {
		return getCollisionGroup() != collidable.getCollisionGroup();
	}

	@Override
	public CollisionGroup getCollisionGroup() {
		return this.collisionGroup;
	}

	public void setCollisionGroup(CollisionGroup collisionGroup) {
		this.collisionGroup = collisionGroup;
	}

	@Override
	public boolean canShot(DeltaState deltaState) {
		return false;
	}

	@Override
	public void shot() {
		getShotStrategy().shot(getScene(), this);
	}

	@Override
	public void tryShot(DeltaState deltaState) {
		if (canShot(deltaState))
			shot();
	}

	public ShipState getShipState() {
		return shipState;
	}

	public void setShipState(ShipState shipState) {
		this.shipState = shipState;
	}

	public int getLifePoints(){
		return getShipState().getLifePoints();
	}

	public ShotStrategy getShotStrategy() {
		return shotStrategy;
	}

	public void setShotStrategy(ShotStrategy shotStrategy) {
		this.shotStrategy = shotStrategy;
	}
}
