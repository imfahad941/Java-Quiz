package qems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class instructionStudent extends JFrame implements ActionListener {
    String rollno;
    JButton start,back;

    instructionStudent(String rollNo)
    {
        this.rollno=rollNo;
        getContentPane().setBackground(Color.white);
        getContentPane().setLayout(null);

        JLabel heading =new JLabel("Welcome RollNo : "+rollno+" to the Quiz");
        heading.setBounds(50,20,700,30);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        heading.setForeground(new Color(30,144,254));
        getContentPane().add(heading);


        JLabel rules =new JLabel();
        rules .setBounds(20,90,700,350);
        rules .setFont(new Font("Tahoma",Font.PLAIN,16));
        rules.setText(
                "<html>"+
                        "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                        "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                        "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                        "4. Crying is allowed but please do so quietly." + "<br><br>" +
                        "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                        "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                        "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                        "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
                        "<html>"
        );
        getContentPane().add(rules );


        start =new JButton("Start");
        start.setBounds(438,470,165,45);
        start.setBackground(new Color(30,144,254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        getContentPane().add(start);


        back =new JButton("Back");
        back.setBounds(135,470,165,45);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        getContentPane().add(back);


        setSize(800,650);
        setLocation(350,100);
        setVisible(true);


    }


    public static void main(String[] args) {

        new instructionStudent("RollNo");  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start)
        {
        	setVisible(false);
            new quizExamStudent(rollno).setVisible(true);
        }
        else if(e.getSource()==back)
        {
        	setVisible(false);
            new studentDetail().setVisible(true);

        }

    }
}

