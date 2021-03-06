package dan0125zpp1.entities.statics;

import java.awt.Graphics;

import dan0125zpp1.Handler;
import dan0125zpp1.gfx.Assets;
import dan0125zpp1.tiles.Tile;

public class Tree extends StaticEntity {
	
	public Tree(Handler handler, float x, float y) {
		super(handler, x,y,Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
	
		bounds.x = 10;
		bounds.y = (int) (height/1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree,  (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()),null);
		
	}
	
	@Override
	public void die() {
		
		
	}
	
}
