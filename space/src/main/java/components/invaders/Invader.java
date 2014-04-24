package components.invaders;

import com.uqbar.vainilla.DeltaState;
import components.Ship;
import components.shotting.Shot;
import resources.Resource;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Invader extends Ship {

    private InvaderMover invaderMover;

    public Invader(Resource resource, double x, double y, double xV, double yV, double speed) {
        super(resource, x, y, xV, yV, speed);
    }

    public Invader(int x, int y, int xV, int yV, int speed) {
        super(x, y, xV, yV, speed);
    }

    public Invader() {
        super();
    }

    @Override
    public void update(DeltaState deltaState){
        getInvaderMover().update(deltaState);
        super.update(deltaState);
    }

    protected InvaderMover getInvaderMover(){
        if(this.invaderMover == null){
            this.invaderMover = new StandardMove(this);
        }
        return invaderMover;
    }

    public void destroy(){
        getScene().getCollidables().remove(this);
        super.destroy();
    }

    @Override
    public Shot createShot() {
        throw new NotImplementedException();
    }
}
