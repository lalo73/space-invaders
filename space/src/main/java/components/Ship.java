package components;

import collisionGroups.CollisionGroup;
import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import scenes.SpaceScene;

public abstract class Ship extends BasicMovingSpaceComponent implements Collidable, Shooter {
    private int lifePoints;
    private int shotPower;
    private CollisionGroup collisionGroup;

    public Ship() {
        super();
        init();
    }

    public Ship(Appearance appearance, double x, double y, double xV, double yV, double speed) {
        super(appearance, x, y, xV, yV, speed);
    }

    public Ship(int x, int y, int xV, int yV, int speed) {
        super(x, y, xV, yV, speed);
    }

    public void init() {
        this.setLifePoints(1);
        this.setShotPower(1);
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getShotPower() {
        return shotPower;
    }

    public void setShotPower(int shotPower) {
        this.shotPower = shotPower;
    }

    @Override
    public void collidedBy(Collidable collidable) {
        setLifePoints(getLifePoints() - 1);
        if (getLifePoints() <= 0) {
            destroy();
        }
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
        getScene().shot(this);
    }
        @Override
    public void tryShot(DeltaState deltaState) {
        if (canShot(deltaState))
            shot();
    }
}
