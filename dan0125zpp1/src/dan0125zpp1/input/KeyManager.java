package dan0125zpp1.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right;
	public boolean attack;
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		attack = keys[KeyEvent.VK_J];
	}
	
	@Override
	public void keyPressed(KeyEvent k) {
		keys[k.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent k) {
		keys[k.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent k) {
				
	}
	
}
