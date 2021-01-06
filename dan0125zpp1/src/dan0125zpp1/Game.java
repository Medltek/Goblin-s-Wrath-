package dan0125zpp1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dan0125zpp1.gfx.Assets;
import dan0125zpp1.gfx.GameCamera;
import dan0125zpp1.gfx.ImageLoader;
import dan0125zpp1.gfx.SpriteSheet;
import dan0125zpp1.input.KeyManager;
import dan0125zpp1.input.MouseManager;
import dan0125zpp1.states.EndGame;
import dan0125zpp1.states.GameState;
import dan0125zpp1.states.MenuState;
import dan0125zpp1.states.State;

public class Game implements Runnable {
	
	private Display display;
	private int width, height; 
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public State gameState;
	public State menuState;
	public State endGame;
	//input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	//camera
	private GameCamera gameCamera;
	
	
	//handler
	private Handler handler;
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0,0);
		
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		endGame = new EndGame(handler);
		State.setState(menuState);
	}
	
	private void tick() {
		keyManager.tick();
		
		if(State.getState()!=null)
			State.getState().tick();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();	
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0, 0, width, height);
		//actual drawing coming
		
		if(State.getState()!=null)
			State.getState().render(g);
		
		//end draw, show it now
		bs.show();
		g.dispose();
	}
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000/fps; //1 billion = nanosecs, more specific than in secs, max amount of time
		double delta = 0;
		long now;
		long lastTime = System.nanoTime(); //clock, curr time of comp in nanosecs
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now-lastTime)/timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
			tick();
			render();
			ticks++;
			delta--;
			}
			if(timer>=1000000000) {
				System.out.println("ticks and frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
