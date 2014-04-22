package scenes.levels;


import components.invaders.Invader;
import resources.Resource;
import scenes.SpaceScene;

public class Level1 extends SpaceScene{
    @Override
    public void addInvaders() {
        Resource resource = Resource.fromImage("invaders/invader1-small.png");
        Invader invader =  new Invader(resource, 20, 20, 0, 1, 0);
        this.addInvader(invader);
    }
}
