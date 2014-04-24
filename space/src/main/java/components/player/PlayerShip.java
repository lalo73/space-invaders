package components.player;


import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.events.constants.Key;
import components.Collidable;
import components.Ship;
import components.shotting.Shot;
import resources.Resource;
import space.SpaceGame;

public class PlayerShip extends Ship {

    private int defaultSpeed;

    public PlayerShip(int x, int y, int xV, int yV, int speed) {
        super(x, y, xV, yV, speed);
        defaultSpeed = speed;
    }

    public PlayerShip(Appearance appearance, int x, int y, int xV, int yV, int speed) {
        super(appearance, x, y, xV, yV, speed);
        defaultSpeed = speed;
    }

    @Override
    public void update(DeltaState deltaState) {
        updateX(deltaState);
        super.update(deltaState);
        tryShot(deltaState);
    }

    @Override
    public boolean canShot(DeltaState deltaState) {
        return deltaState.isKeyReleased(Key.SPACE);
    }

    @Override
    public Shot createShot() {
        Resource resource = getGame().getResource("playerShot");
        int y = (int) (getY() - 10 - resource.getHeight());
        int x = (int) (getX() + (getWidth() / 2) - (resource.getWidth() / 2));
        return new Shot(resource, x, y, 0, -1, 100);
    }

    public void updateX(DeltaState deltaState) {
        setSpeed(0);
        if (deltaState.isKeyBeingHold(Key.LEFT) && !deltaState.isKeyBeingHold(Key.RIGHT)) {
            getUVector().setX(-1);
            setSpeed(defaultSpeed);
        }
        if (deltaState.isKeyBeingHold(Key.RIGHT) && !deltaState.isKeyBeingHold(Key.LEFT)) {
            getUVector().setX(1);
            setSpeed(defaultSpeed);
        }

    }


}
