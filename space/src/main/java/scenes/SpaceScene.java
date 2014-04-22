package scenes;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import components.Ship;
import resources.Resource;
import space.SpaceGame;

import java.util.ArrayList;
import java.util.List;


public class SpaceScene extends GameScene {
    List<Ship> shipList;
    List<Ship> invaderList;
    GameComponent<SpaceScene> background;

    public SpaceScene() {
        super();
        init();
    }

    private void init() {
        setInvaderList(new ArrayList<Ship>());
        setShipList(new ArrayList<Ship>());
    }

    @Override
    public void onSetAsCurrent() {
        super.onSetAsCurrent();
        addBackground();
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

    public void addBackground() {
        Resource resource = getGame().getResource("background");
        this.background = new GameComponent<SpaceScene>(resource, 0, 0);
        addComponents(getBackground());
    }

    public SpaceGame getGame() {
        return (SpaceGame) super.getGame();
    }

    public GameComponent<SpaceScene> getBackground(){
        return this.background;
    }


}
