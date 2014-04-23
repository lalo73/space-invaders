package scenes;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import components.BasicSpaceComponent;
import components.Ship;
import components.invaders.Invader;
import components.player.PlayerShip;
import components.shotting.Shot;
import pool.InvadersPool;
import pool.makers.InvaderMaker;
import resources.Resource;
import space.SpaceGame;

import java.util.ArrayList;
import java.util.List;


public abstract class SpaceScene extends GameScene {
    List<Ship> shipList;
    List<Ship> invaderList;
    List<Shot> shots;
    GameComponent<SpaceScene> background;
    InvadersPool invadersPool;

    public SpaceScene() {
        super();
        init();
    }

    private void init() {
        setInvaderList(new ArrayList<Ship>());
        setShipList(new ArrayList<Ship>());
        setShots(new ArrayList<Shot>());
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

    public void shot(PlayerShip ship) {
        Resource resource = getGame().getResource("shot");
        int y = (int) (ship.getY() - 1 - resource.getHeight());
        int x = (int) (ship.getX() + (ship.getWidth() / 2) - (resource.getWidth() / 2));
        addShot(new Shot(resource, x, y, 0, -1, 100));
    }

    public void addShot(Shot shot) {
        getShots().add(shot);
        addComponent(shot);
    }

    public List<Shot> getShots() {
        return shots;
    }

    public void setShots(List<Shot> shots) {
        this.shots = shots;
    }
}
