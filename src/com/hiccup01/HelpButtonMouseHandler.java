package com.hiccup01;

import com.hiccup01.JSprite.JSpriteMouseEvent;
import com.hiccup01.JSprite.JSpriteMouseEventDelegate;
import com.hiccup01.JSprite.JSpriteMouseHandler;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Open the help file when the user clicks the help button.
 */
public class HelpButtonMouseHandler implements JSpriteMouseHandler {
    File helpFile;

    public HelpButtonMouseHandler() throws IOException {
        this.helpFile = File.createTempFile("wshelp", ".txt"); // Create a temporary file.
        try (InputStream is = getClass().getResourceAsStream("/doc/help.md")) {
            Files.copy(is, this.helpFile.toPath(), StandardCopyOption.REPLACE_EXISTING); // Copy the help file from our jar to the temp file.
        }
    }

    @Override
    public JSpriteMouseEventDelegate scrollEvent(int amount) {
        return null;
    }

    @Override
    public JSpriteMouseEventDelegate mouseClicked(JSpriteMouseEvent m) {
        try {
            Desktop.getDesktop().open(this.helpFile); // Open the help file using the default application
        } catch (Exception e) {
            System.err.println("Failed to open the help file.");
        }
        return JSpriteMouseEventDelegate.COMPLETED;
    }

    @Override
    public JSpriteMouseEventDelegate mouseEntered(JSpriteMouseEvent m) {
        return null;
    }

    @Override
    public JSpriteMouseEventDelegate mouseExited(JSpriteMouseEvent m) {
        return null;
    }

    @Override
    public JSpriteMouseEventDelegate mousePressed(JSpriteMouseEvent m) {
        return null;
    }

    @Override
    public JSpriteMouseEventDelegate mouseReleased(JSpriteMouseEvent m) {
        return null;
    }

    @Override
    public JSpriteMouseEventDelegate mouseDragged(JSpriteMouseEvent m) {
        return null;
    }

    @Override
    public JSpriteMouseEventDelegate mouseMoved(JSpriteMouseEvent m) {
        return null;
    }
}
