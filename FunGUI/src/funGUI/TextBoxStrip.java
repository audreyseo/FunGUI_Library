package funGUI;
import processing.core.*;
import processing.data.StringList;

public class TextBoxStrip implements PConstants {
  float x, y;
  float w, h;
  String text;
  int cursor_placement;
  int begin = 0;
  float textWidth;
  PFont font;
  Timer t, cursorTimer, offTime;
  boolean pressed = false;
  boolean clickedIn = false;
  StringList lines = new StringList();
  PApplet p;
  PGraphics g;
  String command;

  public TextBoxStrip(PApplet p, float x, float y, float w, float h) {
    init(p, x, y, w, h);
  }
  
  public TextBoxStrip(PApplet p, float x, float y, float w, float h, String name) {
	command = name;
	init(p, x, y, w, h);
  }

  public boolean clicked() {
    return(p.mouseX < x + w * .5 && p.mouseX > x - w * .5 && p.mouseY < y + h * .5 && p.mouseY > y - h * .5 && p.mousePressed);
  }

  public void draw() {
    type();
    display();
    limit();
  }

  void display() {
    g.fill(255);
    g.stroke(30);
    g.rectMode(CENTER);
    g.rect(x, y, w, h);
    if (clickedIn && cursorTimer.timeLeft() > 1000) {
      g.fill(30);
      PApplet.println("Begin: " + begin());
      PApplet.println("End: " + end());
      g.rect((float) (x - w * .45 + g.textWidth(text.substring(begin(), end()))), y, 3, (float) (h * .9));
    } else if (cursorTimer.done()) {
      cursorTimer.reset();
    }
    textDisplay();
  }
  
  void textDisplay() {
	  g.textAlign(LEFT, CENTER);
	    g.textFont(font);
	    g.fill(0);
	    g.text(text.substring(begin(), end()), ( float ) (x - w * .45), y);
	    if (command != null) {
	    	g.text(command, ( float ) (x - w * .45), y - 25);
	    }
	  
  }
  
  int begin() {
    return((end() > 0) ? begin : 0);
  }

  int end() {
    return((cursor_placement <= text.length()) ? cursor_placement : text.length());
  }

  void type() {
    if (clicked()) {
      clickedIn = true;
      cursor_placement = begin() + PApplet.round(PApplet.map((float) (p.mouseX), ( float ) (x - w * .5), (float ) (x + w * .5), (float) (0.0), (float) (9.0)));
    }
    if (p.mousePressed && !clicked()) clickedIn = false;
    if (p.keyPressed && typed() && clickedIn) {
      if (t.done() && p.key != CODED && p.key != DELETE && p.key != BACKSPACE) {
        text += PApplet.str(p.key);
        cursor_placement++;
        g.textFont(font);
        if (g.textWidth(text.substring(begin, text.length())) > w * .8) {
          begin ++;
        }
      } else if (t.done()) {
        if (text.length() > 0 && (p.key == DELETE || p.key == BACKSPACE)) {
          text = text.substring(0, text.length() - 1);
          if (cursor_placement > 0) cursor_placement--;
          if (begin > 0) begin--;
        } else if (cursor_placement > 1 && (p.key == CODED)) {
          if (p.keyCode == RIGHT && cursor_placement < text.length()) {
            cursor_placement ++;
            begin++;
          } else if (p.keyCode == LEFT && cursor_placement > 1 && begin > 1) {
            cursor_placement --;
            begin--;
          }
        }
      }
      enter();
      pressed = p.keyPressed;
      t.reset();
    } else if (! p.keyPressed) {
      pressed = p.keyPressed;
    }
//    PApplet.println(clickedIn + "  " + text);
  }
  
  boolean typed() {
	  boolean two = false;
	  if (text.length() > 0) {
		  two = p.key != text.charAt(text.length() - 1);
	  }
	  return(!pressed || two);
  }

  void limit() {
    cursor_placement = PApplet.constrain(cursor_placement, 0, text.length());
    begin = PApplet.constrain(begin, 0, text.length() - wLimits());
  }

  void enter() {
    if (p.key == ENTER || p.key == RETURN) {
      String new_text = text.substring(0, text.length());
      lines.append(new_text);
      text = "";
    }
  }
  
  public String recorded(int n) {
	  n = PApplet.constrain(n, 0, lines.size() - 1);
	  return(lines.get(n));
  }
  public StringList record() {
	  return(lines.copy());
  }

  int wLimits() {
    g.textFont(font);
    float size = g.textWidth(text);
    if (text.length() > 0) {
      for (int i = text.length() - 1; i > 0; i--) {
        size = g.textWidth(text.substring(i, text.length()));
        if (size >= .9 * w) {
          return(text.length() - i);
        }
      }
    }
    return(0);
  }
  
  void init(PApplet p, float x, float y, float w, float h) {
	this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    text = "";
    t = new Timer(1, p);
    cursorTimer = new Timer(2000, p);
    offTime = new Timer(500, p);
    cursor_placement = 0;
    this.p = p;
    this.g = p.g;
    font = this.p.createFont("Times-New-Roman", (float) (h * .8), true);
    g.textFont(font);
    textWidth = g.textWidth(text);
    cursorTimer.reset();
  }
}
