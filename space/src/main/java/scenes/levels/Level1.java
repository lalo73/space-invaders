package scenes.levels;


import components.invaders.Invader;
import resources.Resource;
import scenes.SpaceScene;

public class Level1 extends SpaceScene{
    @Override
    public void addInvaders() {
        Invader invader =  new Invader(getGame().getResource("invader1"), 20, 20, 0, 1, 0);
        this.addInvader(invader);
    }
}
