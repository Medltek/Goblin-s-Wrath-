package dan0125zpp1.tiles;

import java.awt.image.BufferedImage;

import dan0125zpp1.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.rock, id);
	}
	@Override
	public boolean isSolid() {
		return true;
	}
}
