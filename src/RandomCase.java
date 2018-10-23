import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class RandomCase extends JFrame {

    /*
    * Converts input to randomCase
    *
    * Special Cases:
    *       first letter            .75         lowercase
    *       i                       .75         lowercase
    *       L                       .75         uppercase
    *
     */
    public static String convertToRandomCase(String in) {
        String input = in.toLowerCase();
        String output = "";
        double num; //probability that next letter will be uppercase

        for (int i = 0; i < input.length(); i++) {  //every letter is lowercase and this loop must randomly uppercase some of the letters
            num = Math.random();
            if (i == 0 || (i > 0 && input.charAt(i - 1) == ' ')) { //check if this is first character in a word
                if (0.75 > num) {
                    output += input.substring(i, i+1);
                } else {
                    output += input.substring(i, i+1).toUpperCase();
                }
            } else if (input.charAt(i) == 'i') { //check if character is i
                if (0.75 > num) {
                    output += input.substring(i, i+1);
                } else {
                    output += input.substring(i, i+1).toUpperCase();
                }
            } else if (input.charAt(i) == 'l') { //check if character is L
                if (0.75 > num) {
                    output += input.substring(i, i+1).toUpperCase();
                } else {
                    output += input.substring(i, i+1);
                }
            } else {
                if (0.5 > num) {
                    output += input.substring(i, i+1).toUpperCase();
                } else {
                    output += input.substring(i, i+1);
                }
            }
        }
        return output;
    }

    JTextArea inTxt;
    JTextArea outTxt;
    JButton convertBtn;
    JButton clearInBtn;

    public RandomCase() {
        this.setTitle("rAnDOmCasE");
        this.setResizable(false);

        //top input text area
        inTxt = new JTextArea(5, 35);
        JScrollPane inScrollPane = new JScrollPane(inTxt);
        inTxt.setLineWrap(true);
        inTxt.setWrapStyleWord(true);
        inTxt.setFont(new Font("SansSerif", Font.PLAIN, 20));

        //bottom output text area
        outTxt = new JTextArea(5, 35);
        JScrollPane outScrollPane = new JScrollPane(outTxt);
        outTxt.setLineWrap(true);
        outTxt.setWrapStyleWord(true);
        outTxt.setFont(new Font("SansSerif", Font.PLAIN, 20));

        //middle convert text button
        convertBtn = new JButton("cOnVeRT tO rAnDomCaSe");
        convertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outTxt.setText(convertToRandomCase(inTxt.getText()));
            }
        });

        //middle clear input button
        clearInBtn = new JButton("cLeaR INpUt");
        clearInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inTxt.setText("");
            }
        });

        //creating the JFrame
        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(inScrollPane);
        add(clearInBtn);
        add(convertBtn);
        add(outScrollPane);
        setSize(600, 360);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String args[]) {
        new RandomCase();
    }
}
