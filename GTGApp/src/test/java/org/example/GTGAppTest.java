package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GTGAppTest {

    @BeforeEach
    void setUp() {
        SwingUtilities.invokeLater(() -> GTGApp.main(new String[]{}));
    }

    @Test
    void testFrameInitialization() {
        JFrame frame = findFrame("GTG");
        assertNotNull(frame, "Frame should be initialized");
        assertEquals(300, frame.getWidth(), "Frame width should be 300");
        assertEquals(250, frame.getHeight(), "Frame height should be 250");
    }

    @Test
    void testMenuBarExists() {
        JFrame frame = findFrame("GTG");
        assertNotNull(frame, "Frame should be initialized");

        JMenuBar menuBar = frame.getJMenuBar();
        assertNotNull(menuBar, "Menu bar should be present");
        assertEquals(5, menuBar.getMenuCount(), "There should be 5 menus");

        assertEquals("Application", menuBar.getMenu(0).getText());
        assertEquals("Edit", menuBar.getMenu(1).getText());
        assertEquals("View", menuBar.getMenu(2).getText());
        assertEquals("Navigate", menuBar.getMenu(3).getText());
        assertEquals("About", menuBar.getMenu(4).getText());
    }


    private JFrame findFrame(String title) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {}

        for (Frame frame : Frame.getFrames()) {
            if (frame instanceof JFrame && title.equals(frame.getTitle())) {
                return (JFrame) frame;
            }
        }
        return null;
    }
}
