/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.usuario;


/**
 *
 * @author salomeamayarios
 */
public class controlador_usuario {
    
    //metodo iniciar sesion
    public boolean loginUser(usuario objeto){
        
        boolean respuesta = false;
        Connection cn =  Conexion.conectar();
        String sql = "select  usuario, password from tb_usuarios  where usuario =  '" + objeto.getUsuario() + "' and password = '"+objeto.getPassword()+"' ";
        System.out.println("Ejecutando : "+sql);
        Statement st;
        
        try{
            
            
            st =  cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                respuesta = true;
                
            }
           
            
        }catch (SQLException e){
            System.out.println("Error al Iniciar Sesion");
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesion");
            
        }
        
       
        return respuesta;        
      
    }
    
}
