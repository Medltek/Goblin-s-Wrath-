package dan0125zpp1.tiles;

import java.awt.image.BufferedImage;

import dan0125zpp1.gfx.Assets;

public class TreeTile extends Tile {

	public TreeTile(int id) {
		super(Assets.tree, id);
	}
	@Override
	public boolean isSolid() {
		return true;
	}
}
