package components.factories;


import components.invaders.Invader;
import components.states.LastLifeState;
import resources.Resource;
import space.SpaceGame;

import java.util.ArrayList;
import java.util.List;

public class InvaderFactory {

    public static Invader create() {
        return new Invader(0, 0, 1, 0, 0);
    }

    public static Invader createYellow(SpaceGame game) {
        return createByColor(game, "yellow");
    }

    public static Invader createOrange(SpaceGame game) {
        return createByColor(game, "orange");
    }

    public static Invader createViolet(SpaceGame game) {
        return createByColor(game, "violet");
    }

    public static Invader createBlue(SpaceGame game) {
        return createByColor(game, "blue");
    }

    public static Invader createGreen(SpaceGame game) {
        return createByColor(game, "green");
    }

    public static Invader createByColor(SpaceGame spaceGame, String color) {
        Resource resource = spaceGame.getResource(String.format("invader-%s", color));

        return new Invader(new LastLifeState(resource), 0, 0, 1, 0, 0);
    }

    public static List<Invader> getInvaders(int number, SpaceGame game, String color) {
        List<Invader> invaders = new ArrayList<Invader>();
        for (int i = 0; i < number; i++) {
            invaders.add(createByColor(game, color));
        }
        return invaders;
    }

    public static List<Invader> invadersRow(int count, SpaceGame spaceGame, int initX, int initY, int separation, int speed, String color) {
        List<Invader> invaders = new ArrayList<Invader>();
        for (int i = 0; i < count; i++) {
            Invader invader = createByColor(spaceGame, color);
            invader.setX(initX);
            invader.setY(initY);
            invader.getUVector().set(1, 0);
            invader.setSpeed(speed);
            initX += separation + invader.getWidth();
            invaders.add(invader);
        }

        return invaders;
    }
}
