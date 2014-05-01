package components.invaders;

import com.uqbar.vainilla.DeltaState;
import components.states.ShipState;
import resources.Resource;

public class MovingInvader extends Invader {

    public MovingInvader(ShipState shipState, int x, int y, int xV, int yV, int speed) {
        super(shipState, x, y, xV, yV, speed);
        setShotDelay(1);
    }

    protected HorizontalMove getInvaderMover() {
        if (this.invaderMover == null) {
            this.invaderMover = new HorizontalMove(this);
        }
        return (HorizontalMove) invaderMover;
    }

    @Override
    public boolean canShot(DeltaState deltaState) {
        return !getInvaderMover().isStopped() && super.canShot(deltaState);
    }

    @Override
    public int randomSeconds() {
        return 0;
    }

}
