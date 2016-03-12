package fungui;

import processing.core.*;

public class RectButton extends Button {
	float hratio = 1;
	float wratio = 1;
	int [] scheme = new int [3]; //buttons need three colors typically
	boolean pressed = false;
	boolean rollover;

	boolean displayingMessage = false;
	String buttonText;
	PFont font, smallfont, minifont;
	
	int fsize;
	
	PFont sFont;
	PFont mFont;
	PFont myfont1;
	int sfsize, mfsize;
	int beginningWidth = 0;
	int beginningHeight = 0;
	int outside, inside;
	float wid;
	float hei;
	int counting = 0;
	int counter = 0;
	PApplet p;
	PGraphics g;
	int cGrey15;
	

	public RectButton(PApplet p, float nx, float ny, float nw, float nh, int [] ncolors, String ntext, PFont nfont, int nfsize) {
		wid = 20 / w;
		hei = 20 / h;
		this.x = nx;
		this.y = ny;
		this.w = w;
		this.h = h;
		this.p = p;
		this.g = p.g;
		if (w * wrat() < 26 * wrat() && h * hrat() < 26 * hrat()) {
			wid = 9/w;
			hei = 9/w;
			PApplet.println(ntext);
		}
		scheme = ncolors;
		buttonText = ntext;
		font = p.createFont("Baskerville-Italic", 200, true);
		fsize = nfsize;

		//fonts
		minifont = p.createFont("Menlo-regular", 20);
		smallfont = p.createFont("FZLTXHK--GBK1-0", 200, true);
		sFont = p.createFont("FZLTXHK--GBK1-0", 15, true);
		mFont = p.createFont("FZLTXHK--GBK1-0", 19, true);
		myfont1 = p.createFont("FZLTXHK--GBK1-0", 20, true);
		cGrey15 = g.color(250, 250, 250);
		inside = scheme[1];
		outside = scheme[0];
		sfsize = 15;
		mfsize = 19;
		
		 beginningWidth = p.width;
		beginningHeight = p.height;
	}
	
	
	
	void change() {
	    wratio = p.width / beginningWidth;
	    hratio = p.height / beginningHeight;
	  }
	void update() {
		change();
//		if (buttonMessage != null) {
//			buttonMessage.update();
//		}
	}

	void display(String time, PFont displayFont, float fontsize) {
		back();
		g.textFont(displayFont, limitFont(displayFont, fontsize, time, w));
		g.textAlign(CENTER, CENTER);
		g.text(time, x(), y());
	}

	void back() {
		g.rectMode(CENTER);
		g.noStroke();
		g.fill(outside);
		g.rect(x(), y(), w(), h());
		float insideW, insideH;
		insideW = w - 20 * wratio;
		insideH = h - 20 * hratio;
		g.fill(inside);
		g.rect(x(), y(), iw(), ih());
		g.fill(0);
	}


	//MAJOR FUNCTIONS:
	public void draw() {
		/*Function to display the button
	     takes no arguments* bc all of the properties of the button are initialized/created by the initializer, new Button()
		 *other than mX and mY to allow the function rolled_over */
		rolled_over(p.mouseX, p.mouseY);

		display("", font, fsize);

		g.noStroke();
		g.rectMode(CENTER);
		if ((rollover)) {
			g.fill(scheme[0]);
			g.rect(x(), y(), w(), h());
			g.fill(scheme[1]);
			g.rect(x(), y(), w(), h());
			g.fill(scheme[2]);
			g.rect(x(), y(), iw(), ih());
		} else {
			g.fill(scheme[0]);
			g.rect(x(), y(), w(), h());
			g.fill(scheme[1]);
			g.rect(x(), y(), iw(), ih());
		}

		drawButtonName();
	}
	
	void drawButtonName() {
		g.pushStyle();
		g.textFont(font, limitFont(fsize, buttonText, w));
		g.textAlign(CENTER, CENTER);
		g.fill(0);
		g.text(buttonText, x(), y());
		g.popStyle();
		
	}

	void rolled_over(float mX, float mY) {
		//for the buttons that do NOT display messages when the user clicks on them
		if (clickedButton()) {
			rollover = true;
		} else {
			rollover = false; //these buttons need to become false right when they are released
		}

	}



	@Override
	public boolean clicked(float mX, float mY) {
		//for the buttons that do NOT display messages when the user clicks on them
		return(clickedButton()); //these buttons need to become false right when they are released

	}

	//SUPPORTING FUNCTIONS:
	void changeColors(int [] newColors) {
		scheme = newColors;
	}

	boolean clickedButton() {
		return(xmin() < p.mouseX && xmax() > p.mouseX && ymin() < p.mouseY && ymax() > p.mouseY && p.mousePressed);
	}

	boolean state() {
		int state = counting % 2;
		if (state == 0) {
			return false;
		} else if (state == 1) {
			return true;
		} else {
			return false;
		}
	}

//	void createMessage(String tempHeader, String tempMessage, String tempYesOpt, String tempNoOpt, color [] scheme, color [] buttonColors) {
//		buttonMessage = new Message(tempHeader, tempMessage, tempYesOpt, tempNoOpt, scheme, buttonColors);
//	}

	boolean isRolledOver() {
		rolled_over(p.mouseX, p.mouseY);
		return rollover;
	}

	void increaseCount() {
		counter ++;
	}

	boolean returnState() {
		if (counter % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	float wrat() {
		return(p.width / 600);
	}

	float hrat() {
		return(p.height/ 400);
	}

	float ohsix() {
		return(w * wid);
	}

	float ohthree() {
		return(h * hei);
	}
	
	public float y() {
	    return(y * hratio);
	  }
	  
	  @Override
	public float h() {
	    return(h * hratio);
	  }
	  
	  @Override
	public float w() {
	    return(w * wratio);
	  }
	  
	  float x() {
	    return(x * wratio);
	  }
	  
	  float iw() {
	    int n = 20;
	    if (w() < 1.5 * n * wratio) {
	      n = PApplet.floor((float) (w() * .2));
	    }
	    return(w() - n);
	  }
	  
	  float ih() {
	    int n = 20;
	    if (h() < 1.5 * n * hratio) {
	      n = PApplet.floor((float) (h() * .2));
	    }
	    return(h() - n);
	  }

	  float reY() {
	    return y;
	  }

	  float reX() {
	    return x;
	  }

	  float reH() {
	    return h;
	  }

	  float reW() {
	    return w;
	  }

	  float xmin() {
	    return(x() - (w() / 2));
	  }

	  float xmax() {
	    return(x() + (w() / 2));
	  }

	  float ymin() {
	    return(y() - (h() / 2));
	  }

	  float ymax() {
	    return(y() + (h() / 2));
	  }
	  
	  float limitFont(float fontSize, String str, float w) {
//		  float hrat = (float) (p.height / 400.0);
//		  float wrat = (float) (p.width / 600.0);
//		  g.textFont(myfont1, fontSize * hrat);
//		  float twidth = g.textWidth(str);
//		  if (twidth < iw()) {
//			  return(fontSize * hrat);
//		  } else if (fontSize * hrat > ih()) {
//			  return(PApplet.abs((float) (fontSize * hrat * ((ih() / 1.1) / (fontSize * hrat)))));
//		  }
//		  return(PApplet.abs((float) (fontSize * hrat * ((iw() / 1.1) / twidth))));
		  return(fontSize);
	  }

	  float limitFont(PFont font, float fontSize, String str, float w) {
//		  float hrat = (float) (p.height / 400.0);
//		  float wrat = (float) (p.width / 600.0);
//		  g.textFont(font, fontSize * hrat);
//		  float twidth = g.textWidth(str);
//		  if (twidth < iw()) {
//			  return(fontSize * hrat);
//		  }
//		  return(PApplet.abs((float) (fontSize * hrat * (iw() / 1.1) / twidth)));
		  return(fontSize);
	  }
}
