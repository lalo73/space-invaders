package components.shotting;


import collisionGroups.CollisionGroup;
import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.colissions.CollisionDetector;
import components.BasicMovingSpaceComponent;
import components.Collidable;
import scenes.SpaceScene;

public class Shot extends BasicMovingSpaceComponent implements Collidable {
    private CollisionGroup collisionGroup;

    public Shot(Appearance appearance, int x, int y, int xV, int yV, int speed) {
        super(appearance, x, y, xV, yV, speed);
    }

    @Override
    public void update(DeltaState deltaState) {
        super.update(deltaState);
        getScene().verifyCollision(this);
        if (isOutOfScreen()) {
            destroy();
        }

    }

    public boolean isOutOfScreen() {
        return !CollisionDetector.INSTANCE.collidesRectAgainstRect(this.getRect(), getScene().getBackground().getRect());
    }


    public void collide(Collidable collidable) {
        collidable.collidedBy(this);
        destroy();
    }

    @Override
    public void collidedBy(Collidable collidable) {
        destroy();
    }

    @Override
    public void destroy() {
        super.destroy();
        getScene().getCollidables().remove(this);
    }

    @Override
    public GameComponent<SpaceScene> asComponent() {
        return this;
    }

    @Override
    public boolean canCollision(Collidable collidable) {
        return collidable != this && (collidable.getCollisionGroup() == null || getCollisionGroup() != collidable.getCollisionGroup());
    }

    @Override
    public CollisionGroup getCollisionGroup() {
        return this.collisionGroup;
    }

    public void setCollisionGroup(CollisionGroup collisionGroup) {
        this.collisionGroup = collisionGroup;
    }
}
