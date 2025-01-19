import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUI implements ActionListener
{

static final Random ra = new Random();

    JFrame frame;
    JPanel panel;
    JLabel label;
    JButton button;
    JButton buttonSub;
    JButton buttonGamble;
    JButton buttonEnd;
    JButton quitButton;


    int count = 0;
    boolean update = true;

    public GUI()
    {

        frame = new JFrame();

        button = new JButton("Click Me");
        button.addActionListener(this);

        buttonSub = new JButton("Delete Clicks");
        buttonSub.addActionListener(this);

        buttonGamble = new JButton("Gamble Clicks");
        buttonGamble.addActionListener(this);

        buttonEnd = new JButton("End Clicker");
        buttonEnd.addActionListener(this);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(this);
        quitButton.setEnabled(false);

        label = new JLabel("Number of Clicks: " + count);

        panel = new JPanel();


        panel.setBorder(BorderFactory.createEmptyBorder(50, 80, 50, 80));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        panel.add(buttonSub);
        panel.add(buttonGamble);
        panel.add(buttonEnd);
        panel.add(quitButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(1640, 1480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Button Clicker");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args)
    {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {


        if (e.getSource() == button)
            {count++;
            update = true;
            }

        if (e.getSource() == buttonSub)
            { count--;
            update = true;}


        if (e.getSource() == buttonGamble)
            {

            if (count == 0 || count == 1 || count == -1)
                {
                update = false;
                label.setText("Cannot Gamble Clicks. Click some more to gamble!");
                }

            else
                {
                int countG = count / 2;
                int multiplier = ra.nextInt(3) - 3;
                countG *= multiplier;
                count += countG;

                if (multiplier >= 0)
                    {
                    System.out.println("Positive! Multiplier: " + multiplier);
                    }
                else
                    {
                    System.out.println("Negative! Multiplier: " + multiplier);
                    }
                update = true;
                }
            }

        if (update == true)
    label.setText("Number of Clicks: " + count);

        if (e.getSource() == buttonEnd)
            {

            frame.setTitle("Thanks for playing!");
            button.setVisible(false);
            buttonSub.setVisible(false);
            buttonGamble.setVisible(false);
            buttonEnd.setVisible(false);
            System.out.println("\n\n\n");



            JLabel label2 = new JLabel();
            panel.add(label2);
            JLabel label3 = new JLabel();
            panel.add(label3);
            JLabel label4 = new JLabel();
            panel.add(label4);
            JLabel label5 = new JLabel();
            panel.add(label5);
            JLabel label6 = new JLabel();
            panel.add(label6);
            JLabel label7 = new JLabel();
            panel.add(label7);



            label.setText("Java Version: " + System.getProperty("java.version") + " by " + System.getProperty("java.vendor"));
            //label2.setText("User: " + System.getProperty("user.name"));  //<-- TURNED OFF FOR PRIVACY IN THE VIDEO
            label3.setText("Operating System: " + System.getProperty("os.name") + " " + System.getProperty("os.version"));
            label5.setText("Architecture: " + System.getProperty("os.arch"));
            label6.setText("By: Blu");
            label7.setText("Coded for Hack Club High Seas on December 31th 2024");


            System.out.println("\n\n\n");
            System.out.println("Java Version: " + System.getProperty("java.version") + " by " + System.getProperty("java.vendor"));
            //System.out.println("User: " + System.getProperty("user.name"));  //<-- TURNED OFF FOR PRIVACY IN THE VIDEO
            System.out.print("Operating System: " + System.getProperty("os.name"));
            System.out.println(" " + System.getProperty("os.version"));
            System.out.println("Architecture: " + System.getProperty("os.arch"));
            System.out.println ("By: Blu");
            System.out.println ("Coded for Hack Club High Seas on December 31th 2024");

            quitButton.setEnabled(true);
            }

        {
        if (e.getSource() == quitButton)
            {
            System.exit(0);
            }
        }

    }
    }