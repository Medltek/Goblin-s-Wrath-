package dan0125zpp1.entities.statics;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import dan0125zpp1.Handler;
import dan0125zpp1.entities.Entity;
import dan0125zpp1.entities.creatures.Goblin;
import dan0125zpp1.entities.creatures.Player;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
				return -1;
			} 
			return 1;
			
		}
	
	};
	
	public EntityManager(Handler handler, Player player, Goblin goblin, Goblin goblin2, Goblin goblin3, Tree tree) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
		addEntity(goblin);
		addEntity(goblin2);
		addEntity(goblin3);
		addEntity(tree);
	}
	
	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()) {
			Entity e = it.next();
			e.tick();
			if(!e.isActive())
				it.remove();
		}
		entities.sort(renderSorter);
	}
	public void render(Graphics g){
		for(Entity e : entities) {
			e.render(g);
		}
		
	}
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	//getters setters
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	
	
}
