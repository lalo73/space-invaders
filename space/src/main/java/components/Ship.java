package components;

import com.uqbar.vainilla.appearances.Appearance;

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
}
