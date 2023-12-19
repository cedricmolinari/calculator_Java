package org.example.graphical_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserInterface extends JFrame {
    PressedKey pressedKey = new PressedKey();
    JButton button1 = new JButton(String.valueOf(1));
    JButton button2 = new JButton(String.valueOf(2));
    JButton buttonAdd = new JButton("+");
    List<JButton> buttonList;
    String buttonValue;
    public UserInterface() {
        super("Exemple Swing");

        buttonList = new ArrayList<>();
        
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // layout creating and setting
        setLayout(new GridLayout(4, 4, 5, 5));

        // add new components
        add(button1);
        buttonList.add(0, button1);
        
        add(button2);
        buttonList.add(1, button2);

        add(buttonAdd);
        buttonList.add(2, buttonAdd);
        
        
        for (JButton button : buttonList) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonValue = button.getText();
                    handleButtonPress(buttonValue);
                }
            });
        }


        // set the window visible
        setVisible(true);
    }

    private void handleButtonPress(String buttonValue) {
        if (buttonValue == "+") {

        } else {

        }
    }

    public BigDecimal getClickedButtonValue() {
        String stringNumber = buttonValue;
        if (buttonValue != null) {
            return new BigDecimal(stringNumber);
        } else {
            return BigDecimal.ZERO;
        }
    }
}
