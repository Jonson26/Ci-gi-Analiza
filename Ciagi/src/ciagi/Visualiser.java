/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciagi;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Filip
 */
public class Visualiser {
    public void mkWinow(Tree t){
        JFrame f = new JFrame("Tree Visualiser");
        JPanel background = new JPanel();
        background.setBackground(Color.lightGray);
        background.add(newNode(t));
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.add(background);
        f.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),110);
        f.setVisible(true);
    }
    public JPanel newNode(Tree t){
        Border blackline = BorderFactory.createLineBorder(Color.black);
        JPanel background = new JPanel();
        background.setBackground(Color.WHITE);
        background.setBorder(blackline);
        background.add(new JLabel(""+t.a));
        for(int i=0; i<t.nodesCount(); i++){
            if(t.nodesCount()>0){
                background.add(newNode(t.getNode(i)));
            }
        }
        return background;
    }
}
