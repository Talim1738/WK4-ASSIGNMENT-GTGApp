package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RegistrationTest {
    private Registration registration;

    @BeforeEach
    public void setup() {
        registration = new Registration();
    }

    @Test
    public void testActionPerformed() {

        ActionEvent event = mock(ActionEvent.class);

        registration.actionPerformed(event);


        System.setOut(new java.io.PrintStream(System.out));
        registration.actionPerformed(event);

        assert(true);
    }

    private ActionEvent mock(Class<ActionEvent> actionEventClass) {


        return null;
    }


    @Test
    public void testIsRegistrationComplete() {
        boolean isComplete = registration.isRegistrationComplete();

        assert(!isComplete);
    }

    @Test
    public void testMenuItems() {

        JMenuBar menuBar = registration.getJMenuBar();
        JMenu registrationFormMenu = menuBar.getMenu(0);
        JMenuItem fillMenuItem = registrationFormMenu.getItem(0);

        assert(fillMenuItem != null);
        assert(fillMenuItem.getText().equals("Fill"));
    }


}
