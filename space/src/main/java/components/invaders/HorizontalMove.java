package components.invaders;

import com.uqbar.vainilla.DeltaState;
import org.omg.CORBA.TIMEOUT;
import utils.Time;

import java.util.concurrent.TimeUnit;


public class HorizontalMove extends InvaderMover {
    private boolean stopped = true;
    private long lastTimeShowed;

    public HorizontalMove(Invader invader) {
        super(invader);
        setLastTimeShowed(System.nanoTime());
    }

    @Override
    public void update(DeltaState deltaState) {
        if (getInvader().getX() > getInvader().getGame().getDisplayWidth()) {
            getInvader().setX(0 - getInvader().getWidth());
            stopped = true;
            getInvader().setSpeed(0);
            setLastTimeShowed(System.nanoTime());
        }

        if (stopped && Time.havePassed(30, getLastTimeShowed())) {
            stopped = false;
            int defaultSpeed = 100;
            getInvader().setSpeed(defaultSpeed);
        }
        System.out.println(String.format("(%s, %s)", getInvader().getX(), getInvader().getY()));


    }

    public long getLastTimeShowed() {
        return lastTimeShowed;
    }

    public void setLastTimeShowed(long lastTimeShowed) {
        this.lastTimeShowed = lastTimeShowed;
    }
}
