package dan0125zpp1.states;

import java.awt.Graphics;

import dan0125zpp1.Game;
import dan0125zpp1.Handler;

public abstract class State {
	
	//GameStateManager
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	public static State getState() {
		return currentState;
	}
	
	//CLASS
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
