package dan0125zpp1.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int width = 32, height = 32, kWidth = 48, kHeight = 48,gWidth = 64, gHeight = 64;
	public static BufferedImage grass, stone, clay, lava,tree, rock, mountain, background, gameover;
	public static BufferedImage[] knight_down, knight_up, knight_left, knight_right,knight_idle, castle, btn_start, goblin_down, goblin_up, goblin_left, goblin_right;
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/textSheet.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/Knight.png"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/Menu2.jpg"));
		SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/Goblin.png"));
		SpriteSheet sheet5 = new SpriteSheet(ImageLoader.loadImage("/textures/background.jpg"));
		SpriteSheet sheet6 = new SpriteSheet(ImageLoader.loadImage("/textures/gameover.jpg"));
		//textures
		grass = sheet.crop(0, 0, width, height);
		stone = sheet.crop(width*3, height, width, height);
		clay = sheet.crop(width*2, 0, width, height);
		lava = sheet.crop(width*3, 0, width, height);
		tree = sheet.crop(0, height, width, height);
		rock = sheet.crop(width*2, height*14, width, height);
		mountain = sheet.crop(width*15, height*5, width, height);
		
		
		
		castle = new BufferedImage[4];
		castle[0] = sheet.crop(0, height*12, width, height);
		castle[1] = sheet.crop(width, height*12, width, height);
		castle[2] = sheet.crop(width*3, height*12, width, height);
		castle[3] = sheet.crop(width*4, height*12, width, height);
		//goblin
		goblin_down = new BufferedImage[3];
		goblin_up = new BufferedImage[3];
		goblin_left = new BufferedImage[3];
		goblin_right = new BufferedImage[3];
		//---//
		goblin_down[0] = sheet4.crop(gWidth, 0, gWidth, gHeight);
		goblin_down[1] = sheet4.crop(gWidth*4, 0, gWidth, gHeight);
		goblin_down[2] = sheet4.crop(gWidth*6, 0, gWidth, gHeight);
		goblin_left[0] = sheet4.crop(gWidth, gHeight*3, gWidth, gHeight);
		goblin_left[1] = sheet4.crop(gWidth*4, gHeight*3, gWidth, gHeight);
		goblin_left[2] = sheet4.crop(gWidth*6, gHeight*3, gWidth, gHeight);
		goblin_right[0] = sheet4.crop(gWidth, gHeight, kWidth, kHeight);
		goblin_right[1] = sheet4.crop(gWidth*4, gHeight, kWidth, kHeight);
		goblin_right[2] = sheet4.crop(gWidth*6, gHeight, kWidth, kHeight);
		goblin_up[0] = sheet4.crop(gWidth, kHeight*2, kWidth, kHeight);
		goblin_up[1] = sheet4.crop(gWidth*4, kHeight*2, kWidth, kHeight);
		goblin_up[2] = sheet4.crop(gWidth*6, kHeight*2, kWidth, kHeight);
		
		//menu
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet3.crop(2, 2, 70, 29);
		btn_start[1] = sheet3.crop(83, 2, 73, 29);
		
		background  = sheet5.crop(0, 0, 259, 194);
		
		gameover = sheet6.crop(0, 0, 600, 300);
		
		//player
		knight_down = new BufferedImage[3];
		knight_up = new BufferedImage[3];
		knight_left = new BufferedImage[3];
		knight_right = new BufferedImage[3];
		knight_idle = new BufferedImage[2];
		//---//
		knight_idle[0] = sheet2.crop(kWidth, 0, kWidth, kHeight);
		knight_idle[1] = sheet2.crop(kWidth, 0, kWidth, kHeight);
		knight_down[0] = sheet2.crop(0, 0, kWidth, kHeight);
		knight_down[1] = sheet2.crop(kWidth, 0, kWidth, kHeight);
		knight_down[2] = sheet2.crop(kWidth*2, 0, kWidth, kHeight);
		knight_left[0] = sheet2.crop(0, kHeight, kWidth, kHeight);
		knight_left[1] = sheet2.crop(kWidth, kHeight, kWidth, kHeight);
		knight_left[2] = sheet2.crop(kWidth*2, kHeight, kWidth, kHeight);
		knight_right[0] = sheet2.crop(0, kHeight*2, kWidth, kHeight);
		knight_right[1] = sheet2.crop(kWidth, kHeight*2, kWidth, kHeight);
		knight_right[2] = sheet2.crop(kWidth*2, kHeight*2, kWidth, kHeight);
		knight_up[0] = sheet2.crop(0, kHeight*3, kWidth, kHeight);
		knight_up[1] = sheet2.crop(kWidth, kHeight*3, kWidth, kHeight);
		knight_up[2] = sheet2.crop(kWidth*2, kHeight*3, kWidth, kHeight);
	}
}
