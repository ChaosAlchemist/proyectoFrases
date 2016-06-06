package data;

import bd.Data;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class HiloFor implements Runnable {

    JTextArea txtArea;
    private int segundos;
    private int limite;
    private Data d;

    public HiloFor(JTextArea txtArea, int segundos, int limite) {
        try {
            this.txtArea = txtArea;
            this.segundos = segundos;
            this.limite = limite;
            d = new Data();
        } catch (SQLException ex) {
            Logger.getLogger(HiloFor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < limite; i++) {
                String frase = "";
                frase = d.generarFrase();
                try {

                    Thread.sleep(segundos);
                    txtArea.append(frase + "\n" + "\n");
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloFor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HiloFor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
