package components.shotting;


import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.colissions.CollisionDetector;
import components.BasicMovingSpaceComponent;
import components.Collidable;
import components.Ship;

public class Shot extends BasicMovingSpaceComponent implements Collidable{

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


    public void collide(Ship ship) {
        ship.collidedBy(this);
        destroy();
    }

    @Override
    public void collidedBy(Collidable collidable) {
        destroy();
    }
}
