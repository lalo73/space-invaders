package scenes;

import com.uqbar.vainilla.GameScene;
import components.Ship;

import java.util.ArrayList;
import java.util.List;


public class SpaceScene extends GameScene {
    List<Ship> shipList;
    List<Ship> invaderList;

    public SpaceScene() {
        super();
        init();
    }

    private void init() {
        setInvaderList(new ArrayList<Ship>());
        setShipList(new ArrayList<Ship>());
    }

    public List<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(List<Ship> shipList) {
        this.shipList = shipList;
    }

    public List<Ship> getInvaderList() {
        return invaderList;
    }

    public void setInvaderList(List<Ship> invaderList) {
        this.invaderList = invaderList;
    }


}
