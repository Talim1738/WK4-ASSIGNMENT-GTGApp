package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GTGAppIntegrationTest {

    @BeforeEach
    void setUp() {
        SwingUtilities.invokeLater(() -> GTGApp.main(new String[]{}));
    }

    @AfterEach
    void tearDown() {
        for (Frame frame : Frame.getFrames()) {
            if (frame instanceof JFrame) {
                frame.dispose();
            }
        }
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

    @Test
    void testMenuItemsExist() {
        JFrame frame = findFrame("GTG");
        assertNotNull(frame, "Frame should be initialized");

        JMenuBar menuBar = frame.getJMenuBar();
        JMenu fileMenu = menuBar.getMenu(0);
        assertNotNull(fileMenu, "Application menu should be present");

        assertEquals("Application", fileMenu.getText());
        assertTrue(fileMenu.getItemCount() > 0, "Application menu should have items");
    }

    @Test
    void testButtonExists() {
        JFrame frame = findFrame("GTG");
        assertNotNull(frame, "Frame should be initialized");

        JButton button = findButton(frame, "Submit");
        assertNotNull(button, "Submit button should be present");
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

    private JButton findButton(JFrame frame, String text) {
        for (Component component : frame.getContentPane().getComponents()) {
            if (component instanceof JButton && text.equals(((JButton) component).getText())) {
                return (JButton) component;
            }
        }
        return null;
    }
}
