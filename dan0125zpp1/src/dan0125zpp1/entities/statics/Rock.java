package dan0125zpp1.entities.statics;

import java.awt.Graphics;

import dan0125zpp1.Handler;
import dan0125zpp1.gfx.Assets;
import dan0125zpp1.tiles.Tile;

public class Rock extends StaticEntity {
	
	public Rock(Handler handler, float x, float y) {
		super(handler, x,y,Tile.TILE_WIDTH, Tile.TILE_HEIGHT*2);
	
		bounds.x = 3;
		bounds.y = (int) (height/2f);
		bounds.width = width - 6;
		bounds.height = (int) (height - height / 2f);
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rock,  (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()),null);
		
	}

	@Override
	public void die() {
		
		
	}
	
}
