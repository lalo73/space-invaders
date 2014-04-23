package pool.makers;

import components.factories.InvaderFactory;
import components.invaders.Invader;
import space.SpaceGame;

public class InvaderMaker extends ComponentMaker<Invader> {
    public InvaderMaker(SpaceGame spaceGame) {
        super(spaceGame);
    }

    @Override
    public Invader create() {
        return InvaderFactory.create();
    }

}
