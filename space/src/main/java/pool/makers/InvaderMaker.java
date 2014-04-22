package pool.makers;

import components.invaders.Invader;
import resources.Resource;
import space.SpaceGame;

public class InvaderMaker extends ComponentMaker<Invader> {
    public InvaderMaker(SpaceGame spaceGame) {
        super(spaceGame);
    }

    @Override
    public Invader create() {
        return new Invader(0, 0, 1, 0, 0);
    }

    public Invader createYellow(){
        Resource resource = getGame().getResource("invader1");
        return new Invader(resource, 0, 0, 1, 0, 0);
    }
    public Invader createOrange(){
        Resource resource = getGame().getResource("invader2");
        return new Invader(resource, 0, 0, 1, 0, 0);
    }
    public Invader createViolet(){
        Resource resource = getGame().getResource("invader3");
        return new Invader(resource, 0, 0, 1, 0, 0);
    }
    public Invader createBlue(){
        Resource resource = getGame().getResource("invader4");
        return new Invader(resource, 0, 0, 1, 0, 0);
    }
    public Invader createGreen(){
        Resource resource = getGame().getResource("invader5");
        return new Invader(resource, 0, 0, 1, 0, 0);
    }
}
