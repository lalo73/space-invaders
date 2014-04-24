package components.fx;


import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Appearance;
import components.BasicMovingSpaceComponent;

public class NyanCat extends BasicMovingSpaceComponent {

    FXManager fxManager;

    public NyanCat(Appearance appearance, double x, double y, double xV, double yV, double speed) {
        super(appearance, x, y, xV, yV, speed);
    }

    public NyanCat(Appearance appearance, double x, double y, double xV, double yV, double speed, NyanCatManager nyanCatManager) {
        this(appearance, x, y, xV, yV, speed);
        fxManager = nyanCatManager;
    }

    public void update(DeltaState deltaState) {
        super.update(deltaState);
        if (getX() > getGame().getDisplaySize().getWidth())
            destroy();

    }
}
