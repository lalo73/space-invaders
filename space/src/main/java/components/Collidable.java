package components;

/**
 * This interface describes these classes that can be collided by a shot (including them)
 */
public interface Collidable {

    public void collidedBy(Collidable collidable);
}
