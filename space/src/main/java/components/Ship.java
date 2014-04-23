package components;

import com.uqbar.vainilla.appearances.Appearance;
import components.shotting.Shot;

public class Ship extends BasicMovingSpaceComponent {
    private int lifePoints;
    private int shotPower;

    public Ship(){
        super();
        init();
    }

    public Ship(Appearance appearance, double x, double y, double xV, double yV, double speed) {
        super(appearance, x, y, xV, yV, speed);
    }

    public Ship(int x, int y, int xV, int yV, int speed) {
        super(x,y, xV, yV, speed);
    }

    public void init(){
        this.setLifePoints(1);
        this.setShotPower(1);
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getShotPower() {
        return shotPower;
    }

    public void setShotPower(int shotPower) {
        this.shotPower = shotPower;
    }

    public void collidedBy(Shot shot){
        setLifePoints(getLifePoints() - 1);
        if(getLifePoints() <= 0){
            destroy();
        }
    }
}
