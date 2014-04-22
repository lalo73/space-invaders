package components;

import com.uqbar.vainilla.MovingGameComponent;
import scenes.SpaceScene;


public class Ship extends MovingGameComponent<SpaceScene> {
    private int lifePoints;
    private int shotPower;

    public Ship(){
        super();
        init();
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
