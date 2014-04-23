package components.invaders;

import com.uqbar.vainilla.DeltaState;

public class StandardMove extends InvaderMover {
    double initialPosition;

    public StandardMove(Invader invader) {
        super(invader);
        this.initialPosition = invader.getX();
    }

    @Override
    public void update(DeltaState deltaState) {

        if (goingToRight() && invader.getX() > (initialPosition + variance())) {
            invader.getUVector().invertX();
        } else if (goingToLeft() && invader.getX() < (initialPosition - variance())) {
            invader.getUVector().invertX();
        }

    }

    public boolean goingToRight() {
        return invader.getUVector().getX() > 0;
    }

    public boolean goingToLeft(){
        return invader.getUVector().getX() < 0;
    }


    public double variance() {
        return 20;
    }

}
