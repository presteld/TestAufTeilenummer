import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Eingabe {
    private JPanel jpPanel;
    private JLabel lblEingabe;
    private JTextField txtTeilenummer;
    private JButton btnTest;
    private JTextArea taAusgabe;
    private JList jlListe;
    private DefaultListModel lmlistModel = new DefaultListModel();



    public Eingabe() {
        jlListe.setModel(lmlistModel);
        btnTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sTeileNr = txtTeilenummer.getText().toString();

                if (pruefeTeileNr(sTeileNr) == true){

                    taAusgabe.setText("Test der Teilenummer ");
                    taAusgabe.append("\n\n" + sTeileNr);
                    taAusgabe.append("\n\n   OK");

                    lmlistModel.clear();
                    lmlistModel.addElement("Test der Teilenummer ");
                    lmlistModel.addElement("\n\n" + sTeileNr);
                    lmlistModel.addElement("\n\n   OK");
                    System.out.println(lmlistModel);
                }
            }
        });
        txtTeilenummer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    String sTeileNr = txtTeilenummer.getText().toString();
                    if (pruefeTeileNr(sTeileNr) == true){

                        taAusgabe.setText("Test der Teilenummer ");
                        taAusgabe.append("\n\n" + sTeileNr);
                        taAusgabe.append("\n\n   OK");

                        lmlistModel.clear();
                        lmlistModel.addElement("Test der Teilenummer ");
                        lmlistModel.addElement("\n\n" + sTeileNr);
                        lmlistModel.addElement("\n\n   OK");
                        System.out.println(lmlistModel);
                    }
                }
            }
        });
    }

    public boolean pruefeTeileNr(String sTeileNr) {

    try {
        if( !  (sTeileNr.length()  == 10) )
            throw new TeilenummerException(sTeileNr,"\n\nDie Länger der Teilenummer passt nicht\nAktuelle Länge: "+ sTeileNr.length());

        if(   (sTeileNr.startsWith("0")) )
            throw new TeilenummerException(sTeileNr,"\n\nDie Teilenummer  " + sTeileNr+"  startet mit einer 0");


        int[]zifferAnzahl = new int[10];
        char[] ziffern = sTeileNr.toCharArray();

        for(char n: ziffern){
            int ziffer = n -'0';
            zifferAnzahl[ziffer]++;
        }

        int anzahl0=0, anzahldoppelt =0;

        for (int anzahl : zifferAnzahl){
            if (anzahl==0)
                anzahl0++;

            if(anzahl == 2)
                anzahldoppelt++;
        }

        if(   (anzahl0 !=1) )
            throw new TeilenummerException(sTeileNr,"\n\nDie Teilenummer  " + sTeileNr+"  stimmt nicht.\n Eine Ziffer kommt nicht 0-mal vor.");

        if(   (anzahldoppelt != 1) )
            throw new TeilenummerException(sTeileNr,"\n\nDie Teilenummer  " + sTeileNr+"  stimmt nicht.\neine ziffer kommt nicht zweimal vor.");

    }catch (TeilenummerException e){
        taAusgabe.setText("Fehler im Teilenummertest:");
        taAusgabe.append("\n"+ sTeileNr);
        taAusgabe.append(e.getMessage());

        lmlistModel.clear();
        lmlistModel.addElement("Fehler im Teilenummertest:");
        lmlistModel.addElement("\n"+ sTeileNr);
        lmlistModel.addElement("\n"+e.getMessage());
        System.out.println(lmlistModel);

        return false;
    }
        return  true;
    }




    public static void main(String[] args) {
        JFrame frame = new JFrame("Test der eingegeben Teilenummer");
        frame.setContentPane(new Eingabe().jpPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(600,400);
        frame.setVisible(true);
    }
}
