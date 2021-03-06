import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


/**
 * Created by ROMAN on 23.12.2018.
 */


public class Authorization extends JFrame {

    private JButton ok = new JButton("Ок");
    private JButton cancel = new JButton("Отмена");
    //private JTextField loginField = new JTextField("",20);
    //private JLabel loginLabel = new JLabel();

    JTextField loginField;
    JTextField loginField2;
    private final String TITLE_MESSAGE = "Окно сообщения";

    public Authorization() {

        super("Вход в систему");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Box box1 = Box.createHorizontalBox();
        JLabel loginLabel = new JLabel("Логин:");
        loginField = new JTextField(15);
        box1.add(loginLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(loginField);

        JLabel loginLabe2 = new JLabel("Пароль:");
        loginField2 = new JTextField(15);
        box1.add(loginLabe2);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(loginField2);

        Box box2 = Box.createHorizontalBox();
        box2.add(Box.createHorizontalGlue());
        box2.add(ok);
        box2.add(Box.createHorizontalStrut(12));
        box2.add(cancel);

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box2);
        setContentPane(mainBox);
        pack();
        setResizable(false);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (loginField.getText().length() > 0) {

                    JaxbWorker jw = new JaxbWorker();
                    String fileName = "C:/FlashCards/Users.xml";

                    File fn = new File(fileName);
                    if (fn.exists()) {

                        //считать xml файл
                        Users unmarshUsers = jw.fromXmlToObject(fileName);
                        for (User user : unmarshUsers.getUsers()) {

                            if (user.getName().equals(loginField.getText()) & user.getPassword().equals(loginField2.getText())) {

                                MainWindow mw = new MainWindow();
                                setVisible(false);
                            } else {

                                JOptionPane.showMessageDialog(Authorization.this,
                                        new String[]{"Неверные логин или пароль!"},
                                        TITLE_MESSAGE,
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        }

                    } else {

                        //User user = new User();
                        // user.setName(loginField.getText());
                        // user.setPassword(loginField2.getText());

                        //  jw.convertObjectToXml(users, fileName);

                        //   MainWindow mw = new MainWindow();
                        //   setVisible(false);
                    }

                } else {

                    JOptionPane.showMessageDialog(Authorization.this,
                            new String[]{"Введите логин!"},
                            TITLE_MESSAGE,
                            JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(1);

            }
        });

    }
}


