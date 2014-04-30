package components.invaders;

import com.uqbar.vainilla.DeltaState;
import resources.Resource;

public class MovingInvader extends Invader {

    public MovingInvader(Resource resource, double x, int y, int xV, int yV, int speed) {
        super(resource, x, y, xV, yV, speed);
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
