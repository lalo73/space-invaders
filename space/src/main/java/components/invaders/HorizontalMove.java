package components.invaders;

import com.uqbar.vainilla.DeltaState;
import utils.Time;


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
            setStopped(true);
            getInvader().setSpeed(0);
            setLastTimeShowed(System.nanoTime());
        }

        if (isStopped() && Time.havePassed(30, getLastTimeShowed())) {
            setStopped(false);
            int defaultSpeed = 150;
            getInvader().setSpeed(defaultSpeed);
        }
    }

    public long getLastTimeShowed() {
        return lastTimeShowed;
    }

    public void setLastTimeShowed(long lastTimeShowed) {
        this.lastTimeShowed = lastTimeShowed;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
