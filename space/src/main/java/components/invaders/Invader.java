package components.invaders;

import com.uqbar.vainilla.DeltaState;
import components.Ship;
import components.shotting.Shot;
import resources.Resource;
import utils.Time;

import java.util.Random;

public class Invader extends Ship {

    private long lastShotTime;

    protected InvaderMover invaderMover;

    public Invader(Resource resource, double x, double y, double xV, double yV, double speed) {
        super(resource, x, y, xV, yV, speed);
    }

    public Invader(int x, int y, int xV, int yV, int speed) {
        super(x, y, xV, yV, speed);
    }

    public Invader() {
        super();
    }

    @Override
    public void init() {
        super.init();
        setLastShotTime(System.nanoTime());
    }

    @Override
    public void update(DeltaState deltaState) {
        getInvaderMover().update(deltaState);
        super.update(deltaState);
        tryShot(deltaState);
    }

    protected InvaderMover getInvaderMover() {
        if (this.invaderMover == null) {
            this.invaderMover = new StandardMove(this);
        }
        return invaderMover;
    }

    @Override
    public boolean canShot(DeltaState deltaState) {
        long now = System.nanoTime();
        if (Time.havePassed(5, getLastShotTime(), now)) {
            setLastShotTime(Time.plusSeconds(now, randomSeconds()));
            return true;
        }
        return false;
    }

    public int randomSeconds() {
        return (new Random().nextInt(4)) + 1;
    }

    @Override
    public Shot createShot() {
        Resource resource = getGame().getResource("invaderShot");
        int y = (int) (getY() + 10 + resource.getHeight());
        int x = (int) (getX() + (getWidth() / 2) - (resource.getWidth() / 2));
        return new Shot(resource, x, y, 0, 1, 100);
    }

    @Override
    public void destroy(){
        super.destroy();
        getScene().getInvaderShips().remove(this);
    }

    public long getLastShotTime() {
        return lastShotTime;
    }

    public void setLastShotTime(long lastShotTime) {
        this.lastShotTime = lastShotTime;
    }
}
