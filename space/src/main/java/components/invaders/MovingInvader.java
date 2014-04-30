package components.invaders;

import resources.Resource;

public class MovingInvader extends Invader{

    public MovingInvader(Resource resource, double x, int y, int xV, int yV, int speed) {
       super(resource, x, y, xV, yV, speed);
    }

    protected InvaderMover getInvaderMover() {
        if (this.invaderMover == null) {
            this.invaderMover = new HorizontalMove(this);
        }
        return invaderMover;
    }
}
