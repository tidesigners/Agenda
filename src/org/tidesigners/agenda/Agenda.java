
package org.tidesigners.agenda;

import java.sql.SQLException;
import org.tidesigners.dao.ContatoDAO;
import org.tidesigners.logica.Contato;

public class Agenda {

    public static void main(String[] args) throws SQLException {

        Contato contato = new Contato();
        contato.setId(Long.valueOf(3));
     
        ContatoDAO dao = new ContatoDAO();
        dao.remove(contato);
    }

}
