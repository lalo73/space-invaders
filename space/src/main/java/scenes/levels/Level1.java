package scenes.levels;


import components.factories.InvaderFactory;
import components.invaders.Invader;
import scenes.SpaceScene;


public class Level1 extends SpaceScene {
    @Override
    public void addInvaders() {
        for(Invader invader : InvaderFactory.invadersRow(17, getGame(), 20, 20, 5, 10, "green"))
            this.addInvader(invader);

    }
}
