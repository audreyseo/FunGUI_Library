package funGUI;
import processing.core.*;
import processing.event.KeyEvent;

public class Message extends Frame {
	protected char onkey;
	protected char offkey;
	public int fillc;
	public int strokec;
	protected boolean on = false;
	protected String bodyText = "";
	protected String headerText = "";
	protected PFont font;
	
	public Message(PApplet p, String text, String header) {
		onkey = ' ';
		offkey = 's';
		this.bodyText = text;
		this.headerText = header;
		init(p, p.width / 2, p.height / 2, 0, 0);
		splitText();
	}
	
	public Message(PApplet p, float w, float h) {
		onkey = ' ';
		offkey = 's';
		init(p, p.width / 2, p.height / 2, w, h);
		
	}
	
	public Message(PApplet p, char on, char off, String text, String header) {
		onkey = on;
		offkey = off;
		this.bodyText = text;
		this.headerText = header;
		init(p, p.width / 2, p.height / 2, 0, 0);
		splitText();
	}
	
	public Message(PApplet p, float w, float h, char on, char off) {
		onkey = on;
		offkey = off;
		init(p, p.width / 2, p.height / 2, w, h);
		
	}
	
	public Message(PApplet p, float w, float h, char on, char off, String text, String header) {
		onkey = on;
		offkey = off;
		this.bodyText = text;
		this.headerText = header;
		init(p, p.width / 2, p.height / 2, w, h);
		
	}
	
	public Message(PApplet p, float x, float y, float w, float h) {
		onkey = ' ';
		offkey = 's';
		init(p, x, y, w, h);
		
	}
	
	public Message(PApplet p, float w, float h, String text, String header) {
		onkey = ' ';
		offkey = 's';
		this.bodyText = text;
		this.headerText = header;
		init(p, p.width / 2, p.height / 2, w, h);
		
	}
	
	public Message(PApplet p, float x, float y, float w, float h, char on, char off) {
		onkey = on;
		offkey = off;
		init(p, x, y, w, h);
		
	}
	
	private void splitText() {
		String [] lines = PApplet.splitTokens(bodyText, "\n");
		if (lines.length > 1) {

		} else {
			lines = PApplet.splitTokens(bodyText, " ");
			g.textFont(font);
			float total = 0;
			for (int i = 0; i < lines.length; i++) {
				total += g.textWidth(lines[i]);
			}
			this.w = 1.1f * (total / 4);
			this.h = REGTXTSIZE * 4.2f;
			String [] newLines = new String [PApplet.ceil(total / (w / 1.1f))];
			if (newLines.length > 1) {
				int count = 0;
				int i = 0;
				while (count < newLines.length) { 
					String newLine = "";
					while (g.textWidth(newLine + lines[i]) < w) {
						newLine += lines[i];
						i++;
					}
					newLines[count] = newLine;
					count++;
				}
				for (i = 0; i < newLines.length; i++) {
					bodyText = bodyText + newLines + "\n";
				}
			} else {
				return;
			}
		}
	}
	
	public void assignText(String s) {
		bodyText = s;
	}
	
	public void assignHeader(String s) {
		headerText = s;
	}
	
	@Override
	protected void display() {
		if (on) {
			g.pushStyle();
			g.rectMode(CENTER);
			g.fill(fillc);
			g.stroke(strokec);
			g.strokeWeight(2);
			g.rect(x, y, w, h);
			
			g.textFont(font);
			g.fill(0);
			g.textAlign(CENTER, CENTER);
			g.text(bodyText, x, y - h * .5f);
			g.popStyle();
		}
	}
	
	public void keyEvent(KeyEvent e) {
		if (e.getKey() != CODED) {
			if (e.getKey() == onkey) {
			
			} else if (e.getKey() == offkey) {
				
			}
		}
	}
	
	public boolean on() {
		return(on);
	}
	
	@Override
	public String returnName() {
		return("Message");
	}
	
	private void init(PApplet p, float x, float y, float w, float h) {
		this.p = p;
		this.g = p.g;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		fillc = g.color(255, 255, 255);
		strokec = g.color(0);
		p.registerMethod("keyEvent", this);
		font = p.createFont(REG_SANSS_TXT, REGTXTSIZE);
	}

}
