package org.sbx.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.objects.Maze;
import org.sbx.objects.MazeGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aloginov on 14.10.16.
 */
public class FinishDialog extends JDialog{

    private MazeWindow window;

    private static final Logger logger = LogManager.getLogger(FinishDialog.class);
    public FinishDialog(MazeWindow window){
        super(window, "You won!");
        this.window = window;
        logger.info("Game is finished.");

        setLocation(window.getWidth() / 3, window.getHeight() / 3);
        JPanel messagePanel = new JPanel();
        messagePanel.add(new JLabel("You won!"));

        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        buttonPanel.add(okButton);
        okButton.addActionListener(new FinishActionListener());
        getContentPane().add(messagePanel);
        getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    }

    class FinishActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int newSize = Maze.getSize() + 1;
            if (newSize > 15)
                newSize = 3;
            new Paint(MazeGenerator.generateNewMaze(newSize));
            window.dispose();
            dispose();
        }
    }
}
