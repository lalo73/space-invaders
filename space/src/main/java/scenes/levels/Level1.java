package scenes.levels;


import collisionGroups.CollisionGroup;
import com.uqbar.vainilla.GameScene;
import components.factories.InvaderFactory;
import components.invaders.Invader;
import components.invaders.MovingInvader;
import components.player.PlayerShip;
import components.states.LastLifeState;
import resources.Resource;
import scenes.SpaceScene;
import scenes.statics.PressStartScene;


public class Level1 extends SpaceScene {
    private CollisionGroup playersGroup;
    private CollisionGroup invadersGroup;


    @Override
    public void init(){
        super.init();
        addCollisionGroups();
    }

    public void addCollisionGroups(){
        setPlayersGroup(new CollisionGroup());
        setInvadersGroup(new CollisionGroup());
    }

    @Override
    public void addInvaders() {
        String[] colors = {"blue", "green", "violet", "orange", "yellow"};
        int initY = 50;
        int height = 0;
        for (String color : colors) {
            for (Invader invader : InvaderFactory.invadersRow(17, getGame(), 20, initY, 5, 30, color)) {
                invader.setCollisionGroup(getInvadersGroup());
                addInvader(invader);
                height = (int) invader.getHeight();
            }
            initY += height;
        }
        Resource resource = getGame().getResource("invader-yellow");
        MovingInvader movingInvader = new MovingInvader(new LastLifeState(resource), (int) (0 - resource.getWidth()), 10, 1, 0, 0);
        movingInvader.setCollisionGroup(getInvadersGroup());

        addInvader(movingInvader);


    }

    @Override
    public void addPlayers() {
        Resource resource = getGame().getResource("player-ship2");
        PlayerShip playerShip = new PlayerShip(new LastLifeState(resource), getGame().getDisplayWidth() / 2, (int) (getGame().getDisplayHeight() - 20 - resource.getHeight()), 1, 0, 70);
        playerShip.setCollisionGroup(getPlayersGroup());
        addPlayer(playerShip);
    }

    @Override
    public GameScene getNextScene() {
        return new PressStartScene();
    }

    public CollisionGroup getPlayersGroup() {
        return playersGroup;
    }

    public void setPlayersGroup(CollisionGroup playersGroup) {
        this.playersGroup = playersGroup;
    }

    public CollisionGroup getInvadersGroup() {
        return invadersGroup;
    }

    public void setInvadersGroup(CollisionGroup invadersGroup) {
        this.invadersGroup = invadersGroup;
    }
}
