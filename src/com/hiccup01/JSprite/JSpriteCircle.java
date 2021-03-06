package com.hiccup01.JSprite;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * The visual that represents a circle.
 */
public class JSpriteCircle implements JSpriteVisual {
	private int xOffset; // These offsets allow us to have per-costume offsets that allow us to have sprite x and y be the center.
	private int yOffset;
	private int radius; // How big is the circle?
	private Color c = Color.black;
	private JSpriteOffsetMode offsetMode = JSpriteOffsetMode.CENTER;

	public JSpriteCircle(int radius) {
		this.radius = radius;
		this.updateOffsets();
	}
	public JSpriteCircle(int radius, Color c) {
		this(radius);
		this.c = c;
	}

	/**
	 * Gets the current colour.
	 * @return The colour.
	 */
	public Color getColour() {
		return c;
	}

	/**
	 * Sets the circle's colour.
	 * @param c The colour to change to.
	 */
	public void setColour(Color c) {
		this.c = c;
	}

	/**
	 * Gets the current offset mode.
	 * @return The offset mode.
	 */
	public JSpriteOffsetMode getOffsetMode() {
		return this.offsetMode;
	}

	/**
	 * Sets the offset mode.
	 * @param offsetMode The offset mode to change to.
	 */
	public void setOffsetMode(JSpriteOffsetMode offsetMode) {
		this.offsetMode = offsetMode;
		this.updateOffsets();
	}

	/**
	 * Draw the circle.
	 * @param g The graphics object to draw to.
	 * @param x The X position.
	 * @param y The Y position.
	 */
	@Override
	public void draw(Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(this.c);
		g2d.fill(new Ellipse2D.Double(x, y, this.getWidth(), this.getHeight()));
	}

	/**
	 * Is a point within the bounds of the sprite?
	 * @param x The X position to check.
	 * @param y The Y position to check.
	 * @return
	 */
	@Override
	public boolean isInBounds(int x, int y) {
		if(x < 0 || y < 0) return false;
		if(x > this.getWidth() - 1 || y > this.getHeight() - 1) return false;
		float distance = (float)Math.hypot(x - this.radius, y - this.radius);
//		System.err.println("distance is " + distance);
		if(distance > this.radius) return false;
		return true;
	}

	@Override
	public int getWidth() {
		return this.radius * 2;
	}

	@Override
	public int getHeight() {
		return this.radius * 2;
	}

	private void updateOffsets() {
		int height = this.getHeight();
		int width = this.getWidth();
		switch (this.getOffsetMode()) {
			case CENTER:
				this.xOffset = width / 2;
				this.yOffset = height / 2;
				break;
			case TOP_RIGHT:
				this.xOffset = 0;
				this.yOffset = 0;
				break;
			case BOTTOM_LEFT:
				this.xOffset = width;
				this.yOffset = height;
				break;
		}
	}

	@Override
	public int getXOffset() {
		return this.xOffset;
	}

	@Override
	public int getYOffset() {
		return this.yOffset;
	}
}
