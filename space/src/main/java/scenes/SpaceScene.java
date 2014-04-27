package scenes;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.colissions.CollisionDetector;
import components.BasicSpaceComponent;
import components.Collidable;
import components.Ship;
import components.fx.NyanCatManager;
import components.invaders.Invader;
import components.player.PlayerShip;
import components.shotting.Shot;
import pool.InvadersPool;
import resources.Resource;
import scenes.statics.GameOver;
import space.SpaceGame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public abstract class SpaceScene extends GameScene {
    List<Collidable> collidables;
    GameComponent<SpaceScene> background;
    InvadersPool invadersPool;
    List<PlayerShip> playerShips;
    List<Invader> invaderShips;

    public SpaceScene() {
        super();
        init();
    }

    public void init() {
        setPlayerShips(new ArrayList<PlayerShip>());
        setInvaderShips(new ArrayList<Invader>());
        setCollidables(new ArrayList<Collidable>());
    }

    @Override
    public void onSetAsCurrent() {
        super.onSetAsCurrent();
        addBackground();
        setInvadersPool(new InvadersPool(getGame()));
        addInvaders();
        addPlayers();
        addFX();
    }

    public void addFX() {
        addComponent(new NyanCatManager());
    }

    public List<Collidable> iterCollidables() {
        return new ArrayList<Collidable>(collidables);
    }

    public List<Collidable> getCollidables() {
        return this.collidables;
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
        getInvaderShips().add(invader);
        getCollidables().add(invader);
        addComponent(invader);
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
        getCollidables().add(player);
        getPlayerShips().add(player);
        addComponent(player);
    }

    public void addShot(Shot shot) {
        getCollidables().add(shot);
        addComponent(shot);
    }

    public void verifyCollision(Shot shot) {
        for (Collidable collidable : iterCollidables()) {

            if (shot.canCollision(collidable) && CollisionDetector.INSTANCE.collidesRectAgainstRect(shot.getRect(), collidable.asComponent().getRect())) {
                shot.collide(collidable);
            }
        }
    }

    public void removeComponent(GameComponent<?> component) {
        super.removeComponent(component);
    }

    public void setCollidables(ArrayList<Collidable> collidables) {
        this.collidables = collidables;
    }

    public void shot(Ship ship) {
        Shot shot = ship.createShot();
        shot.setCollisionGroup(ship.getCollisionGroup());
        addShot(shot);
    }

    public void takeStep(Graphics2D graphics) {
        super.takeStep(graphics);
        if (getPlayerShips().isEmpty())
            getGame().setCurrentScene(new GameOver());
        if (getInvaderShips().isEmpty())
            getGame().setCurrentScene(getNextScene());

    }

    public abstract GameScene getNextScene();

    public List<PlayerShip> getPlayerShips() {
        return playerShips;
    }

    public void setPlayerShips(List<PlayerShip> playerShips) {
        this.playerShips = playerShips;
    }

    public List<Invader> getInvaderShips() {
        return invaderShips;
    }

    public void setInvaderShips(List<Invader> invaderShips) {
        this.invaderShips = invaderShips;
    }

}
