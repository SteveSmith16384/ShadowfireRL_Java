package com.scs.rogueframework.views;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.List;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TextColor.ANSI;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;
import com.scs.rogueframework.IGameView;

/*
 * An implementation of IGameView; basically ASCII using Lanterna. 
 */
public class LanternaView implements IGameView, WindowListener {

	private static final int WIDTH = 120;

	private Terminal terminal;
	private Screen screen;
	private TextGraphics tGraphics;

	public LanternaView() {//throws IOException {
		DefaultTerminalFactory fac = new DefaultTerminalFactory();
		fac.setInitialTerminalSize(new TerminalSize(WIDTH, 50));
		//fac.setForceTextTerminal(true);
		terminal = fac.createTerminalEmulator(); //.createTerminal();
		SwingTerminalFrame frame = (SwingTerminalFrame) terminal;
		frame.addWindowListener(this);
		try {
			screen = new TerminalScreen(terminal);
		} catch (IOException e) {
			throw new RuntimeException("Error", e);
		}

	}

	/*
	@Override
	public void drawPlayersShipScreen(GameData gameData, Map<String, TextCharacter> seenSquares, List<AbstractAsciiEffect> effects, List<String> helpText, List<Point> route, Point selectedTarget) throws IOException {


	}
	 */

	@Override
	public KeyStroke getInput() throws IOException {
		KeyStroke ks = screen.readInput();
		return ks;
	}


	@Override
	public void close() throws IOException {
		screen.close();
		terminal.close();

	}


	@Override
	public void drawConsoleScreen(List<String> lines, String cmd) throws IOException {
		screen.startScreen();
		screen.clear();

		TextGraphics tGraphics = screen.newTextGraphics();
		tGraphics.setForegroundColor(TextColor.ANSI.GREEN);
		int y = 0;
		for (String s : lines) {
			while (s.length() > 70) {
				String s2 = s.substring(0, 70);
				tGraphics.putString(0, y, s2);
				y++;
				s = s.substring(70);
			}
			tGraphics.putString(0, y, s);
			y++;
		}
		y++;
		tGraphics.putString(0, y, "> " + cmd);
		screen.setCursorPosition(new TerminalPosition(cmd.length()+2, y));
		screen.refresh();

	}


	@Override
	public void drawCharacter(int x, int y, TextCharacter ch) {
		screen.setCharacter(x, y, ch);		
	}


	@Override
	public void windowActivated(WindowEvent arg0) {

	}


	@Override
	public void windowClosed(WindowEvent arg0) {
		System.exit(0);

	}


	@Override
	public void windowClosing(WindowEvent arg0) {

	}


	@Override
	public void windowDeactivated(WindowEvent arg0) {

	}


	@Override
	public void windowDeiconified(WindowEvent arg0) {

	}


	@Override
	public void windowIconified(WindowEvent arg0) {

	}


	@Override
	public void windowOpened(WindowEvent arg0) {

	}

	@Override
	public void startScreen() {
		try {
			screen.startScreen();
			tGraphics = screen.newTextGraphics();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void clear() {
		screen.clear();

	}

	@Override
	public void refresh() {
		try {
			screen.refresh();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void drawString(int x, int y, String s) {
		tGraphics.putString(x, y, s);		
	}

	@Override
	public void setTextForegroundColor(ANSI ansi) {
		tGraphics.setForegroundColor(ansi);		
	}
}
