package com.hiccup01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

    public static void main(String[] args) throws Exception {
        Main gui = new Main();
        gui.doGui();
    }

    public void doGui() throws Exception {
        this.setTitle("JSprite Test");
        this.getContentPane().setPreferredSize(new Dimension(600, 400));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JSpriteCanvas canvas = new JSpriteCanvas();
        canvas.debugMode = true;
        JSprite myRectangle = new JSprite(100, 100, new JSpriteCostume("rect.png"));
        myRectangle.getVisual(0).setOffsetMode(JSpriteOffsetMode.CENTER);
        JSpriteMouseHandler mouseHandle = new JSpriteMouseHandler() {
            @Override
            public boolean scrollEvent(int amount) {
                return false;
            }

            @Override
            public boolean mouseClicked(JSpriteMouseEvent m) {
                return false;
            }

            @Override
            public boolean mouseEntered(JSpriteMouseEvent m) {
            	return false;
            }

            @Override
            public boolean mouseExited(JSpriteMouseEvent m) {
                return false;
            }

            @Override
            public boolean mousePressed(JSpriteMouseEvent m) {
                return false;
            }

            @Override
            public boolean mouseReleased(JSpriteMouseEvent m) {
                return false;
            }

            @Override
            public boolean mouseDragged(JSpriteMouseEvent m) {
//                System.err.println("got a drag event");
//                myRectangle.xPosition = m.getX(JSpriteCoordinateType.VIRTUAL);
//                myRectangle.yPosition = m.getY(JSpriteCoordinateType.VIRTUAL);
//                canvas.repaint();
//                return true;
	            return false;
            }

            @Override
            public boolean mouseMoved(JSpriteMouseEvent m) {
                myRectangle.xPosition = m.getX(JSpriteCoordinateType.VIRTUAL);
                myRectangle.yPosition = m.getY(JSpriteCoordinateType.VIRTUAL);
                canvas.repaint();
                return true;
            }
        };
        myRectangle.addMouseHandler(mouseHandle);
        canvas.setDefaultMouseHandler(new JSpriteMouseHandler() {

            @Override
            public boolean scrollEvent(int amount) {
                return false;
            }

            @Override
            public boolean mouseClicked(JSpriteMouseEvent m) {
                return false;
            }

            @Override
            public boolean mouseEntered(JSpriteMouseEvent m) {
                return false;
            }

            @Override
            public boolean mouseExited(JSpriteMouseEvent m) {
                return false;
            }

            @Override
            public boolean mousePressed(JSpriteMouseEvent m) {
                return false;
            }

            @Override
            public boolean mouseReleased(JSpriteMouseEvent m) {
                return false;
            }

            @Override
            public boolean mouseDragged(JSpriteMouseEvent m) {
                return false;
            }

            @Override
            public boolean mouseMoved(JSpriteMouseEvent m) {
            	
            	if(canvas.eventHandler.findSpriteAt(m.getX(JSpriteCoordinateType.VIRTUAL), m.getY(JSpriteCoordinateType.VIRTUAL)) != null) {
            	    System.err.println("Over a sprite");
                }
                return false;
            }
        });
        canvas.addSprite(myRectangle, 0);
        this.add(canvas);
        this.pack();
        this.toFront();
        this.setVisible(true);
    }
}
