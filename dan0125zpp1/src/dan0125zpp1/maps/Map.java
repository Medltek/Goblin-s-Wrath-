package dan0125zpp1.maps;

import java.awt.Graphics;

import dan0125zpp1.Game;
import dan0125zpp1.Handler;
import dan0125zpp1.entities.creatures.Goblin;
import dan0125zpp1.entities.creatures.Player;
import dan0125zpp1.entities.statics.EntityManager;
import dan0125zpp1.entities.statics.Tree;
import dan0125zpp1.tiles.Tile;
import dan0125zpp1.utils.Utils;

public class Map {
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	//entities
	private EntityManager entityManager;
	
	public Map(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler,
				new Player(handler, 100, 100, 100),
				new Goblin(handler, 200, 50, 10),
				new Goblin(handler, 200, 200, 10),
				new Goblin(handler, 200, 400, 10),
				new Tree(handler, 400, 300));
		
		loadMap(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}

	public void tick() {
		entityManager.tick();
	}
	public void render(Graphics g) {
		int xStart=(int)Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILE_WIDTH);
		int xEnd=(int) Math.min(width,  (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart=(int)Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILE_HEIGHT);;
		int yEnd=(int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for(int y=yStart;y<yEnd;y++) {
			for(int x=xStart;x<xEnd;x++) {
				getTile(x,y).render(g,(int) (x*Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
						(int) (y*Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//entitties
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		
		if (x<0 || y<0 || x>=width || y>=height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t==null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadMap(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
			}
		}
	}
	//getters setters
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
