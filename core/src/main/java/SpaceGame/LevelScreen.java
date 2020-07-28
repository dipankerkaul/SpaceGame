package SpaceGame;

import com.badlogic.gdx.Input.Keys;


public class LevelScreen extends BaseScreen
{
    private Spaceship spaceship;
    public void initialize()
    {
        BaseActor space = new BaseActor(0,0, mainStage);
        space.loadTexture( "space.png" );
        space.setSize(800,600);
        BaseActor.setWorldBounds(space);
        spaceship = new Spaceship(400,300, mainStage);

    }
    public void update(float dt)
    { }

    // override default InputProcessor method
    public boolean keyDown(int keycode)
    {
        if ( keycode == Keys.X )
            spaceship.warp();
        return false;
    }
}
