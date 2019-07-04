import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ROMAN on 23.12.2018.
 */
public class MainWindow extends JFrame {

    private JButton word_add = new JButton("+");
    private JButton word_delete = new JButton("-");

    private JButton language_add = new JButton("+");
    private JButton language_delete = new JButton("-");

    private JTable table;
    private JTable table_language;

    private HashMap<String, ArrayList> dictionary;

    public static String[][] AL_languages = {
            {"en", "Английский"},
            {"de", "Немецкий"},
            {"it", "Итальянский"},
            {"fi", "Финский"},
            {"fr", "Французский"}};

    String[] col = {""};
    Object[][] data = new Object[0][1];

    String[] col_lang = {"", ""};
    Object[][] data_lang = new Object[AL_languages.length][2];

    public MainWindow() {

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.WRAP_TAB_LAYOUT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //////////////////////////////////////////////////////////////////////////
        JPanel panel2 = new JPanel();

        for (int i = 0; i < AL_languages.length; i++) {
            data_lang[i][0] = new Boolean(false);
            data_lang[i][1] = AL_languages[i][1];

        }

        table_language = new JTable(data_lang, col_lang) {
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(450, 300);
            }
        };

        table_language.setCellSelectionEnabled(true);
        table_language.setVisible(true);
        JScrollPane scroll__language = new JScrollPane(table_language);

        panel2.add(language_add);
        panel2.add(language_delete);
        panel2.add(scroll__language);
        tabbedPane.add("Языки", panel2);
        /////////////////////////////////////////////////////////////////////////

        table = new JTable(data, col);
        table.setCellSelectionEnabled(true);
        table.setVisible(true);
        JScrollPane scroll = new JScrollPane(table);

        JPanel panel1 = new JPanel();

        Box box2 = Box.createHorizontalBox();
        box2.add(Box.createHorizontalGlue());
        box2.add(word_add);
        box2.add(Box.createHorizontalStrut(5));
        box2.add(word_delete);

        panel1.add(box2);
        panel1.add(scroll);
        tabbedPane.add("Словарь", panel1);


        //////////////////////////////////////////////////////////////////////////

        JPanel panel3 = new JPanel();

        tabbedPane.add("Карточки", panel3);


        getContentPane().add(tabbedPane).setBackground(Color.WHITE);
        setSize(540, 300);
        setVisible(true);
        setResizable(false);

        word_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

}
