package components.player;


import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.events.constants.Key;
import components.Collidable;
import components.Ship;

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
