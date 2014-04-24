package components.fx;


import com.uqbar.vainilla.DeltaState;
import components.BasicSpaceComponent;
import utils.Time;

public abstract class FXManager extends BasicSpaceComponent {

    private long lastRun;

    public FXManager() {
        super();
        lastRun = System.nanoTime();
    }

    public abstract int runEvery();

    public abstract void showFX();

    @Override
    public void update(DeltaState deltaState) {
        super.update(deltaState);
        if (Time.havePassed(runEvery(), lastRun)){
            showFX();
            this.lastRun = System.nanoTime();
        }

    }

}
