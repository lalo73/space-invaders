package components;

import collitionGroups.CollisionGroup;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import components.shotting.Shot;
import scenes.SpaceScene;

public class Ship extends BasicMovingSpaceComponent implements Collidable{
    private int lifePoints;
    private int shotPower;
    private CollisionGroup collisionGroup;

    public Ship(){
        super();
        init();
    }

    public Ship(Appearance appearance, double x, double y, double xV, double yV, double speed) {
        super(appearance, x, y, xV, yV, speed);
    }

    public Ship(int x, int y, int xV, int yV, int speed) {
        super(x,y, xV, yV, speed);
    }

    public void init(){
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
        if(getLifePoints() <= 0){
            destroy();
        }
    }

    @Override
    public GameComponent<SpaceScene> asComponent() {
        return this;
    }

    @Override
    public boolean canCollition(Collidable collidable) {
        return getCollisionGroup() != collidable.getCollisionGroup();
    }

    @Override
    public CollisionGroup getCollisionGroup() {
        return this.collisionGroup;
    }

    public void setCollisionGroup(CollisionGroup collisionGroup) {
        this.collisionGroup = collisionGroup;
    }
}
