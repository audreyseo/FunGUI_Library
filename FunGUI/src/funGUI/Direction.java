package funGUI;

public enum Direction {
	LEFT(-1, 0),
	UP(0, -1),
	DOWN(0, 1),
	RIGHT(1, 0);
	int x;
	int y;
	public int getX() {
		return(x);
	}
	public int getY() {
		return(y);
	}
	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
