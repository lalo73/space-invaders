package components;


import com.uqbar.vainilla.DeltaState;
import components.shotting.Shot;

public interface Shooter {

    public boolean canShot(DeltaState deltaState);

    public void shot();

    public void tryShot(DeltaState deltaState);

    public Shot createShot();
}
