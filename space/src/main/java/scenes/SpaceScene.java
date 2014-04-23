package scenes;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import components.BasicSpaceComponent;
import components.Ship;
import components.invaders.Invader;
import components.player.PlayerShip;
import pool.InvadersPool;
import pool.makers.InvaderMaker;
import resources.Resource;
import space.SpaceGame;

import java.util.ArrayList;
import java.util.List;


public abstract class SpaceScene extends GameScene {
    List<Ship> shipList;
    List<Ship> invaderList;
    GameComponent<SpaceScene> background;
    InvadersPool invadersPool;

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
        setInvadersPool(new InvadersPool(getGame()));
        addInvaders();
        addPlayers();
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
        this.background = new BasicSpaceComponent(resource, 0, 0);
        addComponents(getBackground());
    }

    public SpaceGame getGame() {
        return (SpaceGame) super.getGame();
    }

    public GameComponent<SpaceScene> getBackground() {
        return this.background;
    }

    public void addInvader(Invader invader) {
        this.getInvaderList().add(invader);
        this.addComponent(invader);
    }

    public InvadersPool getInvadersPool() {
        return invadersPool;
    }

    public void setInvadersPool(InvadersPool invadersPool) {
        this.invadersPool = invadersPool;
    }

    public abstract void addInvaders();

    public abstract void addPlayers();

    public void addPlayer(PlayerShip player) {
        getShipList().add(player);
        addComponent(player);
    }


}
