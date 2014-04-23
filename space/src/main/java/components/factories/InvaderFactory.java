package components.factories;


import components.invaders.Invader;
import resources.Resource;
import space.SpaceGame;

import java.util.ArrayList;
import java.util.List;

public class InvaderFactory {

    public static Invader create(){
        return new Invader(0, 0, 1, 0, 0);
    }

    public static Invader createYellow(SpaceGame game){
        Resource resource = game.getResource("invader-yellow");
        return new Invader(resource, 0, 0, 1, 0, 0);
    }
    public static Invader createOrange(SpaceGame game){
        Resource resource = game.getResource("invader-orange");
        return new Invader(resource, 0, 0, 1, 0, 0);
    }
    public static Invader createViolet(SpaceGame game){
        Resource resource = game.getResource("invader-violet");
        return new Invader(resource, 0, 0, 1, 0, 0);
    }
    public static Invader createBlue(SpaceGame game){
        Resource resource = game.getResource("invader-blue");
        return new Invader(resource, 0, 0, 1, 0, 0);
    }

    public static Invader createGreen(SpaceGame game){
        Resource resource = game.getResource("invader-green");
        return new Invader(resource, 0, 0, 1, 0, 0);
    }

    public static List<Invader> getInvaders(int number, SpaceGame game){
        List<Invader> invaders = new ArrayList<Invader>();
        for (int i = 0; i < number; i++) {
            invaders.add(createGreen(game));
        }
        return invaders;
    }

    public static List<Invader> invadersRow(int count, SpaceGame spaceGame, int initX, int initY, int separation, int speed){
        List<Invader> invaders = new ArrayList<Invader>();
        for (int i = 0; i < count; i++) {
            Invader invader = createGreen(spaceGame);
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
