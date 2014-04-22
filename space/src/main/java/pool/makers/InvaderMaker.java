package pool.makers;

import components.invaders.Invader;
import space.SpaceGame;

public class InvaderMaker extends ComponentMaker<Invader> {
    public InvaderMaker(SpaceGame spaceGame) {
        super(spaceGame);
    }

    @Override
    public Invader create() {
        return new Invader(0, 0, 1, 0, 0);
    }
}
