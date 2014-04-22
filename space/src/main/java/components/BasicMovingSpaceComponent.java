package components;


import com.uqbar.vainilla.MovingGameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import scenes.SpaceScene;

public class BasicMovingSpaceComponent extends MovingGameComponent<SpaceScene> {
    public BasicMovingSpaceComponent(Appearance appearance, double x, double y, double xV, double yV, double speed){
        super(appearance, x, y, xV, yV, speed);
        setInitZ();
    }

    public BasicMovingSpaceComponent() {
        super();
        setInitZ();
    }

    private void setInitZ(){
        setZ(2);
    }

}
