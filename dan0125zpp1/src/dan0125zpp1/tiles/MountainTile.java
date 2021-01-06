package dan0125zpp1.tiles;

import java.awt.image.BufferedImage;

import dan0125zpp1.gfx.Assets;

public class MountainTile extends Tile {

	public MountainTile(int id) {
		super(Assets.mountain, id);
	}
	@Override
	public boolean isSolid() {
		return true;
	}
}