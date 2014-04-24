package components;


import com.uqbar.vainilla.DeltaState;

public interface Shooter {

    public boolean canShot(DeltaState deltaState);

    public void shot();

    public void tryShot(DeltaState deltaState);
}
