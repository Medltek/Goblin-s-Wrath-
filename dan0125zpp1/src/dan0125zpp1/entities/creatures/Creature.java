package dan0125zpp1.entities.creatures;

import dan0125zpp1.Game;
import dan0125zpp1.Handler;
import dan0125zpp1.entities.Entity;
import dan0125zpp1.tiles.Tile;

public abstract class Creature extends Entity {
	
	public static final float DEFAULT_SPEED = 1.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 32,
							DEFAULT_CREATURE_HEIGHT = 32;
	
	
	protected int tempMove=1;
	protected float speed;
	protected float xMove,yMove;
	
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
	}
	public void moveX() {
		if(xMove >0) {
			int xtemp = (int) (x + xMove + bounds.x+bounds.width)/Tile.TILE_WIDTH;
			if(!collisionWithTile(xtemp, (int) (y+ bounds.y)/Tile.TILE_HEIGHT) && 
					!collisionWithTile(xtemp, (int) (y + bounds.y + bounds.height) /Tile.TILE_HEIGHT)) {
				x+=xMove;
			}else tempMove = -tempMove;
		
		
		}else if(xMove < 0) {//left
			int xtemp = (int) (x + xMove + bounds.x)/Tile.TILE_WIDTH;
			if(!collisionWithTile(xtemp, (int) (y+ bounds.y)/Tile.TILE_HEIGHT) && 
					!collisionWithTile(xtemp, (int) (y + bounds.y + bounds.height) /Tile.TILE_HEIGHT)) {
				x+=xMove;
			}else tempMove = -tempMove;
		}
	}
	public void moveY() {
		if(yMove < 0) {//up
			int ytemp = (int) (y + yMove + bounds.y)/ Tile.TILE_HEIGHT;
			if(!collisionWithTile((int)(x + bounds.x)/Tile.TILE_WIDTH,ytemp) &&
					!collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.TILE_WIDTH,ytemp)) {
				y+=yMove;
			}
		}else if(yMove>0){//down
			int ytemp = (int) (y + yMove + bounds.y + bounds.height)/ Tile.TILE_HEIGHT;
			if(!collisionWithTile((int)(x + bounds.x)/Tile.TILE_WIDTH,ytemp) &&
					!collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.TILE_WIDTH,ytemp)) {
				y+=yMove;
			}
		}
	}
	
	@Override
	public void die() {
		
		
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getMap().getTile(x,y).isSolid();
	}
	//getter, setters
	public float getxMove() {
		return xMove;
	}
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}
	public float getyMove() {
		return yMove;
	}
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
	
}
