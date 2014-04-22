package components.invaders;

import com.uqbar.vainilla.DeltaState;
import components.Ship;
import resources.Resource;

public class Invader extends Ship {

    public Invader(Resource resource, double x, double y, double xV, double yV, double speed) {
        super(resource, x, y, xV, yV, speed);
    }

    public Invader(int x, int y, int xV, int yV, int speed) {
        super(x, y, xV, yV, speed);
    }

    @Override
    public void update(DeltaState deltaState){
        super.update(deltaState);
    }
}
