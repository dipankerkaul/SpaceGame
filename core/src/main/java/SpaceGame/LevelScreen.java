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
        new Rock(600,500, mainStage);
        new Rock(600,300, mainStage);
        new Rock(600,100, mainStage);
        new Rock(400,100, mainStage);
        new Rock(200,100, mainStage);
        new Rock(200,300, mainStage);
        new Rock(200,500, mainStage);
        new Rock(400,500, mainStage);


    }
    public void update(float dt)
    {
        for ( BaseActor rockActor : BaseActor.getList(mainStage, Rock.class) )
        {
            if (rockActor.overlaps(spaceship))
            {
                if (spaceship.shieldPower <= 0)
                {
                    Explosion boom = new Explosion(0,0, mainStage);
                    boom.centerAtActor(spaceship);
                    spaceship.remove();
                    spaceship.setPosition(-1000,-1000);
                }
                else
                {

                    spaceship.shieldPower -= 34;
                    Explosion boom = new Explosion(0,0, mainStage);
                    boom.centerAtActor(rockActor);
                    rockActor.remove();
                }
            }
            for ( BaseActor laserActor : BaseActor.getList(mainStage, Laser.class) )
            {
                if (laserActor.overlaps(rockActor))
                {
                    Explosion boom = new Explosion(0,0, mainStage);
                    boom.centerAtActor(rockActor);
                    laserActor.remove();
                    rockActor.remove();
                }
            }
        }
    }

    // override default InputProcessor method
    public boolean keyDown(int keycode)
    {
        if ( keycode == Keys.X )
            spaceship.warp();
        if ( keycode == Keys.SPACE )
            spaceship.shoot();
        return false;


    }


}
