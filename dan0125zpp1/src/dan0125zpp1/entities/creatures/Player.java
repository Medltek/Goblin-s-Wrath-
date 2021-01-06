package dan0125zpp1.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dan0125zpp1.Game;
import dan0125zpp1.Handler;
import dan0125zpp1.entities.Entity;
import dan0125zpp1.gfx.Animation;
import dan0125zpp1.gfx.Assets;
import dan0125zpp1.states.State;

public class Player extends Creature {

	private Animation animDown, animUp, animLeft, animRight, animIdle;
	private long lastAttackTimer, attackCooldown = 500, attackTimer = attackCooldown;
	public Player(Handler handler, float x, float y, int health) {
		super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.speed = 3.0f;
		bounds.x = 8;
		bounds.y = 16;
		bounds.width = 16;
		bounds.height = 16;
		
		animDown = new Animation(500, Assets.knight_down);
		animUp = new Animation(500, Assets.knight_up);
		animLeft = new Animation(500, Assets.knight_left);
		animRight = new Animation(500, Assets.knight_right);
		animIdle = new Animation(500, Assets.knight_down);
	}

	@Override
	public void tick() {
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		animIdle.tick();
		
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		//attack
		checkAttacks();
	}
	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		
		if(attackTimer<attackCooldown)
			return;
		
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 50;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().attack) {
			ar.x = cb.x+cb.width;
			ar.y = cb.y+cb.height;
			
		}else {
			return;
		}
		
		attackTimer = 0;
		
		for(Entity e : handler.getMap().getEntityManager().getEntities()) {
			if(e.equals(this))
				continue;
			
			if(e.getCollisionBounds(0, 0).intersects(ar)) {
				System.out.println("dmg dealt = 5");
				e.hurt(5);
				return;
			}
		}
	}
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),(int) (x-handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	
		//g.setColor(Color.red);
		//g.fillRect((int) (x+bounds.x - handler.getGameCamera().getxOffset()), (int) (y+bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		
		
	}
	
	@Override
	public void die() {
		if(!this.active) {
			handler.getMouseManager().setUIManager(null);
			State.setState(handler.getGame().endGame);
		}
		System.out.println("you lose");
		
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove <0) {
			return animLeft.getCurrentFrame();
		}else if(xMove >0) {
			return animRight.getCurrentFrame();
		}else if(yMove <0) {
			return animUp.getCurrentFrame();
		}else if(yMove>0){
			return animDown.getCurrentFrame();
		}else return(animIdle.getCurrentFrame());
		
		
	}
}
