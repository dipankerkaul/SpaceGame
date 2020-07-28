package SpaceGame.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import SpaceGame.SpaceGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
public class DesktopLauncher
{
	public static void main (String[] args)
	{
		Game myGame = new SpaceGame();
		LwjglApplication launcher = new LwjglApplication( myGame, "Space Rocks", 800, 600 );
	}
}

