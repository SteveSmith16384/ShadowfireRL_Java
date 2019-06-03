package com.scs.rogueframework;

import java.io.IOException;
import java.util.List;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.ANSI;
import com.googlecode.lanterna.input.KeyStroke;

/**
 * An abstract implementation of the game view.
 * 
 * @author StephenCS
 *
 */
public interface IGameView {

	void startScreen();
	
	void clear();
	
	void refresh();
	
	void drawConsoleScreen(List<String> lines, String cmd) throws IOException;
	
	void drawCharacter(int x, int y, TextCharacter ch);
	
	void setTextForegroundColor(ANSI ansi);
	
	void drawString(int x, int y, String s);
	
	KeyStroke getInput() throws IOException;

	void close() throws IOException;

}
