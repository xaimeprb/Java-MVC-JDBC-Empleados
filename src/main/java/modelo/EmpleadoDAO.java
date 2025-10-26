package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object de la clase Empleado, la cual encapsula todas las operaciones a la base de datos relacionadas con los empleados
 * @author xaime
 * @since 24/10/2025
 */
public class EmpleadoDAO {
    
    public List<Empleado> busquedaEmpleadosPorLocalidadYOficio(String localidadInsertada, String oficioInsertado) throws SQLException {
        
        List<Empleado> empleados = new ArrayList<>();
        
        String query = """
                        SELECT e.id, e.apellido, e.oficio, e.dir, e.fecha_alta, e.salario, e.comision, e.dept_no, d.dnombre  AS departamento, d.loc AS localidad
                        FROM empleados AS e
                        JOIN departamentos AS d ON d.id = e.dept_no
                        WHERE UPPER(d.loc) = UPPER(?) AND UPPER(e.oficio) = UPPER(?);        
                        """;
        
        Connection con = JDBCSingleton.getInstance().getConnection();
        
        try (PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setString(1, localidadInsertada);
            ps.setString(2, oficioInsertado);
            
            try (ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {
                    
                    int id = rs.getInt("id");
                    String apellido = rs.getString("apellido");
                    String oficio = rs.getString("oficio");
                    int dir = rs.getInt("dir");
                    Timestamp fechaAlta = rs.getTimestamp("fecha_alta");
                    
                    // Manera fácil, pero si queremos usarlo menos veces lo hacemos en el constructor de la clase Empleado
                    // var conversor = new Conversor();
                    // LocalDate fecha = conversor.convDate2LocalDate(rs.getDate("fecha_alta"));
                    
                    int salario = rs.getInt("salario");
                    int comision = rs.getInt("comision");
                    int dept_no = rs.getInt("dept_no");
                    
                    var empleado = new Empleado(id, apellido, oficio, dir, fechaAlta, salario, comision, dept_no);
                    
                    empleados.add(empleado);
                    
                }
                
            }
            
        } catch (SQLException e) {
            
            throw e;
            
        }
        
        return empleados;

    }
    
}
