/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private Connection conexion;
    private void abrirConexion() throws SQLException{
        String url, usuario, password;
        url = "jdbc:derby://localhost:1527/Restaurant";
        usuario = "Angel";
        password = "angel";
        conexion = DriverManager.getConnection(url,usuario,password);
    }
    private void cerrarConexion() throws SQLException{
        conexion.close();
    }
    public void registrar(Usuario usuario) throws SQLException{
        try{
            abrirConexion();
            String nombre = usuario.getNombre();
            String correo = usuario.getCorreo();
            String contrasenia = usuario.getContrasenia();
            String sql = "insert into USUARIOS values ('"+nombre+"', '"+correo+"', ', '"+contrasenia+"";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
            cerrarConexion();
        }catch(SQLException registroFallido){
            System.out.println("El error fue al momento del registro");
        }
    }
    public String NombreDeUsuario(Usuario usuario) throws SQLException{
            usuario = Usuario.getUser();
            abrirConexion();
            ResultSet registros;
            String nombreDeUsuario = usuario.getNombre();
            String contrasenia = usuario.getContrasenia();
            String info = "";
            String sql = "select * from USUARIOS where (nombreDeUsuario = '"+nombreDeUsuario+"' AND contrasenia = '"+contrasenia+"' )";
            Statement stmt = conexion.createStatement();
            registros = stmt.executeQuery(sql);
            while(registros.next()){
                info = registros.getString("nombreDeUsuario");
            }
            cerrarConexion();
            return info;
    }
    public String Correo(Usuario usuario) throws SQLException{
            usuario = Usuario.getUser();
            abrirConexion();
            ResultSet registros;
            String nombreDeUsuario = usuario.getNombre();
            String contrasenia = usuario.getContrasenia();
            String info = "";
            String sql = "select * from USUARIOS where (nombreDeUsuario = '"+nombreDeUsuario+"' AND contrasenia = '"+contrasenia+"' )";
            Statement stmt = conexion.createStatement();
            registros = stmt.executeQuery(sql);
            while(registros.next()){
                info = registros.getString("correo");
            }
            cerrarConexion();
            return info;
    }
}
