package test;

import datos.*;
import domain.*;
import java.sql.*;

public class TestManejoPersonas {

    public static void main(String[] args) throws SQLException {

        Connection conexion = null;

        //Aseguramos que autocommit es falso y adaptamos el código
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);

                //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
                personaDAO personaDao = new personaDAO(conexion);
                Persona cambioPersona = new Persona();
                cambioPersona.setIdPersona(5);
                cambioPersona.setId_cambio(3);
//                cambioPersona.setNombre("Karla");
//                cambioPersona.setApellidos("Karly");
//                cambioPersona.setEmail("Karla@iesserpis.com");
//                cambioPersona.setEdad(26);
                
                //UPDATE
                personaDao.update_ID(cambioPersona);
                
//                Persona nuevaPersona = new Persona();
//                nuevaPersona.setNombre("Carlos");
//                nuevaPersona.setApellidos("Ramirez");
                
                //INSERTAR
//                Persona nueva_persona = new Persona("fasddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd", "fdsafsad", 4);
//                personaDao.insertar(nueva_persona);
                
//                personaDao.insertar(nuevaPersona);

                //Ahora añadimos la parte de código para confirmar que se ejecuten los cambios
                conexion.commit();
                System.out.println("Se ha hecho commit de la transaccion");
            }
            
        //Ahora añadimos la parte de código para anular los cambios (rollback)
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
