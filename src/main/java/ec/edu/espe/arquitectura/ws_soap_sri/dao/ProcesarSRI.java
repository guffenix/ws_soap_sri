/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.ws_soap_sri.dao;

import ec.edu.espe.arquitectura.ws_soap_sri.modelo.ContribuyenteGenerico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.Stateless;




/**
 *
 * @author Rolando Cachipuendo
 */
@Stateless
public class ProcesarSRI {

    public ContribuyenteGenerico obtenerSri(String identificacion) throws  SQLException, ClassNotFoundException {

        ContribuyenteGenerico gen = new ContribuyenteGenerico();
        Class.forName("org.mariadb.jdbc.Driver");
        //Connection con = DriverManager.getConnection("jdbc:mariadb://192.168.99.100:33306/SRI" + "?user=root&password=mariadb");
        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/SRI" + "?user=mariadb&password=mariadb");
        Statement st = con.createStatement();
        //identificacion="171286053001001";

        String sql = "select * from CONTRIBUYENTE where CON_RUC='" + identificacion + "'";
        String ae = "select ACT_DESCRIPCION FROM ACTIVIDAD_ECONOMICA "
                + "where ACT_CODIGO IN(select ACT_CODIGO from ACT_ECO_CONTRIBUYENTE a "
                + "where a.CON_CODIGO IN(SELECT CON_CODIGO FROM CONTRIBUYENTE C "
                + "WHERE C.CON_RUC ='" + identificacion + "'))";
        ResultSet rs = st.executeQuery(sql);
//        ResultSet rs1= st.executeQuery("select ACT_DESCRIPCION FROM ACTIVIDAD_ECONOMICA where ACT_CODIGO IN(select ACT_CODIGO from ACT_ECO_CONTRIBUYENTE)");
        ResultSet rs1 = st.executeQuery(ae);
        while (rs.next()) {
            gen.setTipo(rs.getNString("CON_TIPO"));
            gen.setApellido(rs.getNString("CON_APELLIDO"));
            gen.setNombre(rs.getNString("CON_NOMBRE"));
//            System.out.println("vale " + rs.getNString("CON_CODIGO"));
//            System.out.println("vale " + rs.getNString("CON_TIPO"));
//            System.out.println("vale " + rs.getNString("CON_APELLIDO"));
//            System.out.println("vale " + rs.getNString("CON_NOMBRE"));

        }
        while (rs1.next()) {
            gen.setActividadEconomica(rs1.getString(1));
//            System.out.println("vale" + rs1.getString(1));
        }
//        System.out.println(gen);
        con.close();
        return gen;
    }

}
