package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

class RegistrationIntegrationTest {

    private Registration registration;

    @BeforeEach
    public void setup() {

        registration = new Registration();
    }


    @Test
    public void testIsRegistrationComplete_integration() {

        boolean isComplete = registration.isRegistrationComplete();
        assert(!isComplete);
    }

    @Test
    public void testMenuItems_integration() {
        JMenuBar menuBar = registration.getJMenuBar();
        JMenu registrationFormMenu = menuBar.getMenu(0);
        JMenuItem fillMenuItem = registrationFormMenu.getItem(0);


        assert(fillMenuItem != null);

        assert(fillMenuItem.getText().equals("Fill"));
    }


    private ActionEvent mock(Class<ActionEvent> actionEventClass) {

        return mock(ActionEvent.class);
    }
}
