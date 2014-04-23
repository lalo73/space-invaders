package components.invaders;


import com.uqbar.vainilla.DeltaState;

public abstract class InvaderMover {
    Invader invader;

    public InvaderMover(Invader invader) {
        setInvader(invader);
    }
    public abstract void update(DeltaState deltaState);

    public void setInvader(Invader invader) {
        this.invader = invader;
    }

    public Invader getInvader() {
        return invader;
    }
}
