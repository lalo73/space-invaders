package scenes.levels;


import components.factories.InvaderFactory;
import components.invaders.Invader;
import scenes.SpaceScene;


public class Level1 extends SpaceScene {
    @Override
    public void addInvaders() {
        String[] colors = {"blue", "green", "violet", "orange", "yellow"};
        int initY = 20;
        for(String color: colors){
            for(Invader invader : InvaderFactory.invadersRow(17, getGame(), 20, initY, 5, 10, color))
                this.addInvader(invader);
            initY += this.getInvaderList().get(0).getHeight();
        }


    }
}
