package components.shotting;


import com.uqbar.vainilla.appearances.Appearance;
import components.BasicMovingSpaceComponent;
import resources.Resource;

public class Shot extends BasicMovingSpaceComponent {

    public Shot(Appearance appearance, int x, int y, int xV, int yV, int speed) {
        super(appearance, x, y, xV, yV, speed);
    }
}
