package dan0125zpp1.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dan0125zpp1.Game;
import dan0125zpp1.Handler;

public abstract class Entity {
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public static final int DEFAULT_HEALTH = 10;
	
	protected Handler handler;
	protected float x,y;
	protected int width, height;
	protected Rectangle bounds;
	protected int health;
	protected boolean active = true;
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		health = DEFAULT_HEALTH;
		
		bounds = new Rectangle(0,0, width, height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void die();
	
	public void hurt(int dmg) {
		health -= dmg;
		if(health <= 0) {
			active = false;
			die();
		}
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for(Entity e : handler.getMap().getEntityManager().getEntities()) {
			if(e.equals(this))
					continue;
			if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle ((int)(x+bounds.x + xOffset), (int)(y+bounds.y + yOffset), bounds.width, bounds.height);
	}
	//getters setters
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
}
