package com.scs.shadowfirerl.components;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.scs.ecs.components.AbstractComponent;

public class GraphicComponent extends AbstractComponent {

	private TextCharacter ch;
	
	public GraphicComponent(char _ch, TextColor.ANSI foreground, TextColor.ANSI background) {
		ch = new TextCharacter(_ch, foreground, background);
	}
	
	
	public TextCharacter getChar() {
		return ch;
	}

}
