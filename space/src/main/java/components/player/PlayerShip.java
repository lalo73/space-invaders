package components.player;


import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.events.constants.Key;
import components.Collidable;
import components.Ship;
import components.shotting.Shot;
import components.states.ShipState;
import resources.Resource;
import space.SpaceGame;

public class PlayerShip extends Ship {

    private int defaultSpeed;

    public PlayerShip(int x, int y, int xV, int yV, int speed) {
        super(x, y, xV, yV, speed);
        defaultSpeed = speed;
    }

    public PlayerShip(ShipState shipState, int x, int y, int xV, int yV, int speed) {
        super(shipState, x, y, xV, yV, speed);
        defaultSpeed = speed;
    }

    @Override
    public void update(DeltaState deltaState) {
        updateX(deltaState);
        super.update(deltaState);
        fixX();
        tryShot(deltaState);
    }

    @Override
    public boolean canShot(DeltaState deltaState) {
        return deltaState.isKeyReleased(Key.SPACE);
    }

    @Override
    public Shot createShot() {
        Resource resource = getGame().getResource("playerShot");
        int y = (int) (getY() - (resource.getHeight() / 2));
        int x = (int) (getX() + (getWidth() / 2) - (resource.getWidth() / 2));
	    Shot shot = new Shot(resource, x, y, 0, -1, 100);
	    shot.setCollisionGroup(getCollisionGroup());
        return shot;
    }

    public void updateX(DeltaState deltaState) {
        if (isMoving(deltaState)) {
            if (isMovingToLeft(deltaState))
                getUVector().setX(-1);
            else
                getUVector().setX(1);
            setSpeed(defaultSpeed);
        } else {
            setSpeed(0);
        }
    }

    public boolean isMoving(DeltaState deltaState) {
        return isMovingToLeft(deltaState) ^ isMovingToRight(deltaState);
    }

    public boolean isMovingToRight(DeltaState deltaState) {
        return deltaState.isKeyBeingHold(Key.RIGHT) && !deltaState.isKeyBeingHold(Key.LEFT);
    }

    public boolean isMovingToLeft(DeltaState deltaState) {
        return deltaState.isKeyBeingHold(Key.LEFT) && !deltaState.isKeyBeingHold(Key.RIGHT);
    }

    @Override
    public void destroy() {
        super.destroy();
        getScene().getPlayerShips().remove(this);
    }

    /**
     * TODO: improve this
     */
    private void fixX() {
        if (getX() < 0)
            setX(0);
        if (getX() + getWidth() > getGame().getDisplayWidth())
            setX(getGame().getDisplayWidth() - getWidth());
    }


}
