package scenes.levels;


import components.factories.InvaderFactory;
import components.invaders.Invader;
import components.player.PlayerShip;
import resources.Resource;
import scenes.SpaceScene;


public class Level1 extends SpaceScene {
    @Override
    public void addInvaders() {
        String[] colors = {"blue", "green", "violet", "orange", "yellow"};
        int initY = 20;
        int height = 0;
        for (String color : colors) {
            for (Invader invader : InvaderFactory.invadersRow(17, getGame(), 20, initY, 5, 30, color)) {
                addInvader(invader);
                height = (int) invader.getHeight();
            }
            initY += height;
        }


    }

    @Override
    public void addPlayers() {
        Resource resource = getGame().getResource("player-ship1");
        addPlayer(new PlayerShip(resource, getGame().getDisplayWidth() / 2, (int) (getGame().getDisplayHeight() - 20 - resource.getHeight()), 1, 0, 70));
    }
}
