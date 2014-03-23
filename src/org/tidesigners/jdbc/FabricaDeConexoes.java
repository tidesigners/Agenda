package org.tidesigners.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class FabricaDeConexoes {

    private static Connection con;

    private FabricaDeConexoes() {
    }

    public static Connection conectar() {
        try {

            if (con == null || con.isClosed()) {

                //Passo 1: carregar o driver.
                Class.forName("com.mysql.jdbc.Driver");

                //Passo 2: configurar.
                String url = "jdbc:mysql://localhost:3306/agendadb";
                String usr = "root";
                String pwd = "xy453232";

                //Passo 3: conectar.
                con = DriverManager.getConnection(url, usr, pwd);

                //Passo 4: fazer um "log" da conexão.
                DatabaseMetaData dbmd = con.getMetaData();
                System.out.println("Conectado ao BD: "
                        + dbmd.getDatabaseProductName() + " - Versão: "
                        + dbmd.getDatabaseProductVersion());
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return con;
    }

    public static void desconectar() {

        try {

            if (con != null && !con.isClosed()) {

                con.close();
            }
        } catch (Exception e) {
        }
    }
}
