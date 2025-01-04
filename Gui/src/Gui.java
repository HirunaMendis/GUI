import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.JDBCType;
import java.util.Set;

public abstract class Gui extends JFrame implements ActionListener {

    JLabel title, name , email , gender , password;
    JTextArea tname , temail , tpassword;
    JRadioButton male , female;
    JCheckBox robot;
    JButton submit;
    ButtonGroup genderbutton;






    private Container c;

    public Gui(){
        setTitle("Registration Form");
        setBounds(300,90,500,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c= getContentPane();
        c.setLayout(null);

         title = new JLabel("Sign up");
        title.setFont(new Font("Arial",Font.PLAIN,20));
        title.setForeground(Color.blue);
        title.setSize(160,40);
        title.setLocation(200,5);
        c.add(title);
/////////////////////////////////////////////////
         name = new JLabel("Name");
        name.setFont(new Font("Arial",Font.PLAIN,20));
        name.setSize(200,40);
        name.setLocation(100,60);
        c.add(name);

         tname =new JTextArea();
        tname.setFont(new Font("Arial",Font.PLAIN,15));
        tname.setSize(150,20);
        tname.setLocation(200,70);
        c.add(tname);
//////////////////////////////////////////////////
         email = new JLabel("email");
        email.setFont(new Font("Arial",Font.PLAIN,20));
        email.setSize(200,40);
        email.setLocation(100,80);
        c.add(email);

        temail =new JTextArea();
        temail.setFont(new Font("Arial",Font.PLAIN,15));
        temail.setSize(150,20);
        temail.setLocation(200,100);
        c.add(temail);
/////////////////////////////////////////////////////

         gender = new JLabel("Gender");
        gender.setFont(new Font("Arial",Font.PLAIN,20));
        gender.setSize(200,40);
        gender.setLocation(100,110);
        c.add(gender);

         male = new JRadioButton("male");
        male.setFont(new Font("Arial",Font.PLAIN,15));
        male.setSize(100,40);
        male.setLocation(200,110);
        c.add(male);

         female = new JRadioButton("female");
        female.setFont(new Font("Arial",Font.PLAIN,15));
        female.setSize(100,40);
        female.setLocation(300,110);
        c.add(female);


        //////////////////////////////////////////
         password = new JLabel("password");
        password.setFont(new Font("Arial",Font.PLAIN,20));
        password.setSize(200,40);
        password.setLocation(100,150);
        c.add(password);

         tpassword =new JTextArea();
        tpassword.setFont(new Font("Arial",Font.PLAIN,15));
        tpassword.setSize(150,20);
        tpassword.setLocation(200,160);
        c.add(tpassword);

        ///////////////////////

         robot = new JCheckBox("I'm not a robot");
        robot.setFont(new Font("Arial",Font.PLAIN,20));
        robot.setSize(200,40);
        robot.setLocation(100,200);
        robot.setFocusPainted(false);
        c.add(robot);

        /////////////////////////

         submit = new JButton("Submit");
        submit.setFont(new Font("Arial",Font.PLAIN,20));
        submit.setForeground(Color.WHITE);
        submit.setSize(100,20);
        submit.setLocation(200,250);
        submit.setBackground(Color.BLUE);
        submit.addActionListener(this);
        c.add(submit);

         genderbutton = new ButtonGroup();
        genderbutton.add(male);
        genderbutton.add(female);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = tname.getText().trim();
                String email = temail.getText().trim();
                String password = tpassword.getText().trim();

                String gender = male.isSelected() ? "male" : "female";

                if (!robot.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please confirm you are not a robot!");
                    return; // Stop further execution
                }



                JDBC jdbc = new JDBC();

                boolean result = jdbc.registerUser(name, email, gender, password);

                if (result) {
                    JOptionPane.showMessageDialog(null, "Registration Successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Registration Failed. Try again.");
                }

            }




        });


    }

}
