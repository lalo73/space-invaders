package scenes.levels;


import components.invaders.Invader;
import pool.makers.InvaderMaker;
import resources.Resource;
import scenes.SpaceScene;

public class Level1 extends SpaceScene {
    @Override
    public void addInvaders() {
        Invader invader = getInvadersPool().getComponentMaker().createGreen();
        invader.setX(20);
        invader.setY(20);
        this.addInvader(invader);
    }
}
