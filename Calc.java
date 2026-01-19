import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc {

    public static void main(String[] args) {

        new CalcDemo();
    }
}

class CalcDemo extends JFrame implements ActionListener {

    JButton button1, button2, button3, button4;
    JTextArea area1, area2, area3;
    //JLabel label1;

    CalcDemo() {

        area1 = new JTextArea();
        area1.setBounds(50,50,250,25);
        area2 = new JTextArea();
        area2.setBounds(50,100,250,25);

        button1 = new JButton("Add");
        button1.setBounds(50,150,250,25);
        button2 = new JButton("Substraction");
        button2.setBounds(50,200,250,25);
        button3 = new JButton("Multiplication");
        button3.setBounds(50,250,250,25);
        button4 = new JButton("Division");
        button4.setBounds(50,300,250,25);

        area3 = new JTextArea("result");
        area3.setBounds(50,350,250,25);

        add(area1);
        add(area2);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(area3);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {

        int x = Integer.parseInt(area1.getText());
        int y = Integer.parseInt(area2.getText());
        int result = 0;

        if(ae.getSource() == button1)
            result = x+y;

        else if (ae.getSource() == button2)
            result = x-y;

        else if (ae.getSource() == button3)
            result = x*y;

        else if (ae.getSource() == button4)
            result = x/y;


        area3.setText(result + " ");
    }
}