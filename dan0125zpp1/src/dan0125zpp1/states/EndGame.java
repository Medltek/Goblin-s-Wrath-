package dan0125zpp1.states;

import java.awt.Color;
import java.awt.Graphics;

import dan0125zpp1.Game;
import dan0125zpp1.Handler;
import dan0125zpp1.gfx.Assets;
import dan0125zpp1.ui.Background;
import dan0125zpp1.ui.ClickListener;
import dan0125zpp1.ui.UIImageButton;
import dan0125zpp1.ui.UIManager;

public class EndGame extends State {

	private UIManager uiManager;
	
	public  EndGame(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new Background(0,0,800,600,Assets.gameover));
		uiManager.addObject(new UIImageButton(336, 100, 128, 64,Assets.btn_start, new ClickListener(){
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
		uiManager.addObject(new Background(0,0,800,600,Assets.gameover));
	}
	
	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
