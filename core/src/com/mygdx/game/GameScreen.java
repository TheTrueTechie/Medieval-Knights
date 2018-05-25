package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen {

	World world;
	MedievalKnights game; 
	Player player;
	KeyInput inputs;
	int currentHP = 100;
	int maxHP = 100;
	int currentSA = 100;
	int maxSA = 100;
	
	
	public void create(MedievalKnights game) {
		world = new World();
		this.game = game; 
		inputs = new KeyInput();
		background = new Texture("Grass_Complete_RPG.png");
		//player = new Player(currentHP,maxHP,currentSA,maxSA, 5,2, "John", "A Guy",new Texture("New_Piskel.png"),15,15);
		player = new Player(100,100,100, 100, 5,2, "John", "A Guy",new Texture("New_Piskel.png"),150,150,world.getWorldX(),world.getWorldY());
		inputs.setPlayer(player);
		Gdx.input.setInputProcessor(inputs);
		
		game.gameState++;
	}

	public void render (SpriteBatch batch) {
		player.move();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		world.render(batch);
		player.render(batch);
		batch.draw(player.getImg(),player.getX()-32,player.getY()-32,64,64); 

		batch.setProjectionMatrix(player.camera.combined);
		batch.end();
	}



	public void dispose () {
		game.getBatch().dispose();
	}
}
