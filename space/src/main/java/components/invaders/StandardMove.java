package components.invaders;

import com.uqbar.vainilla.DeltaState;

public class StandardMove extends InvaderMover {
    double initialPosition;
    int direction = 1;

    public StandardMove(Invader invader) {
        super(invader);
        this.initialPosition = invader.getX();
    }

    @Override
    public void update(DeltaState deltaState) {

        if(goingToRight()){
            this.invader.setX(this.invader.getX() + distance(deltaState.getDelta()));
        } else {
            this.invader.setX(this.invader.getX() - distance(deltaState.getDelta()));
        }

        if((direction > 0 && this.invader.getX() > initialPosition + variance()) || (direction < 0 && this.invader.getX() < initialPosition - variance()) ){
            direction = -direction;
        }

    }

    public boolean goingToRight(){
        return direction == 1;
    }

    public double distance(double delta){
        return 3*delta;
    }

    public double variance(){
        return 10;
    }

}
