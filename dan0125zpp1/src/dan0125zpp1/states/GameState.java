package dan0125zpp1.states;

import java.awt.Graphics;

import dan0125zpp1.Game;
import dan0125zpp1.Handler;
import dan0125zpp1.entities.creatures.Player;
import dan0125zpp1.entities.statics.Tree;
import dan0125zpp1.gfx.Assets;
import dan0125zpp1.maps.Map;

public class GameState extends State {

	
	private Map map;
	
	
	public GameState(Handler handler) {
		super(handler);
		map = new Map(handler, "res/maps/map1.txt");
		handler.setMap(map);
	}
	
	@Override
	public void tick() {
		map.tick();
		
		
	}
	@Override
	public void render(Graphics g) {
		map.render(g);
		
		
	}

}
