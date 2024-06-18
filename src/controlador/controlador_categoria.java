/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

//import com.mysql.jdbc.Statement;
//import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import conexion.Conexion;
import modelo.Categoriaa;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author salomeamayarios
 */
public class controlador_categoria {
    
    // va a recibir un objeto de clase categoria
    // metodo para registrar categoria
    public boolean guardar(Categoriaa objeto){
        boolean respuesta = false;
        Connection cn =  Conexion.conectar();
        
        try{
            PreparedStatement consulta = cn.prepareStatement("insert into tb_categoria values(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());
            
            if(consulta.executeUpdate() > 0){
                respuesta = true;
                
            }
            cn.close();
            
        }catch(SQLException e){
            System.out.println("Error al guardar categoria: "+e);
            
        }
        return respuesta;
    }
    
    //consultar si existe la categoria 
    public boolean existeCategoria(String categoria){
        boolean respuesta = false;
        
        String sql = "select descripcion from tb_categoria where descripcion = '"+categoria+"';";
        Statement st;
        
        
        
        try{
            Connection cn = Conexion.conectar();
            st =  cn.createStatement();
            ResultSetImpl rs = (ResultSetImpl) st.executeQuery(sql);
            while(rs.next()){
                respuesta = true;
                
            }
            
                
            
            
        }catch(SQLException e){
            System.out.println("Error al consultar categoria: "+e);
            
        }
        return respuesta;
    }
    // metodo actualizar categorias 
    public boolean actualizar(Categoriaa objeto, int idCategoria){
        boolean respuesta = false;
        Connection cn =  Conexion.conectar();
        
        try{
            PreparedStatement consulta = cn.prepareStatement("update tb_categoria set descripcion=? where idCategoria='"+idCategoria+'"');
            consulta.setString(1, objeto.getDescripcion());
          
            
            if(consulta.executeUpdate() > 0){
                respuesta = true;
                
            }
            cn.close();
            
        }catch(SQLException e){
            System.out.println("Error al actualizar categoria: "+e);
            
        }
        return respuesta;
    }
    
    public boolean eliminar(int idCategoria){
        boolean respuesta = false;
        Connection cn =  Conexion.conectar();
        // si le paso como id dos se me va a borar la categoria que tenfa en el id 2
        
        try{
            PreparedStatement consulta = cn.prepareStatement("delete from tb_categoria where idCategoria ='" + idCategoria + "'");
            consulta.executeUpdate();
          
            
            if(consulta.executeUpdate() > 0){
                respuesta = true;
                
            }
            cn.close();
            
        }catch(SQLException e){
            System.out.println("Error al eliminar categoria: "+e);
            
        }
        return respuesta;
    }
    
}
