package SpaceGame;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
public class Spaceship extends BaseActor
{
    public Spaceship(float x, float y, Stage s)
    {
        super(x,y,s);
        loadTexture( "spaceship.png" );
        setBoundaryPolygon(8);
        setAcceleration(200);
        setMaxSpeed(100);
        setDeceleration(10);
    }
    public void act(float dt)
    {
        super.act( dt );
        float degreesPerSecond = 120; // rotation speed
        if (Gdx.input.isKeyPressed(Keys.LEFT))
            rotateBy(degreesPerSecond * dt);
        if (Gdx.input.isKeyPressed(Keys.RIGHT))
            rotateBy(-degreesPerSecond * dt);
        if (Gdx.input.isKeyPressed(Keys.UP))
            accelerateAtAngle( getRotation() );

        applyPhysics(dt);
        wrapAroundWorld();
    }
}