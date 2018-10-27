package br.edu.etep.creche.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String banco = "jdbc:mysql://localhost/bdcreche";
    private static final String usuario = "root";
    private static final String senha = "12345";
    private static Connection con = null;

    public static Connection getConexao() {

        if (con == null) {
            try {

                Class.forName(driver);
                con = DriverManager.getConnection(banco, usuario, senha);

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Não encontrou o driver");
            } catch (SQLException ex) {
                System.out.println("Erro ao conectar: "
                        + ex.getMessage());
            }
        }
        return con;
    }

    public static PreparedStatement getPreparedStatement(String sql) {

        if (con == null) {

            con = getConexao();
        }
        try {

            return con.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Erro de sql: "
                    + e.getMessage());
        }
        return null;
    }

}
