package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.EmpleadoDAO;
import vista.VentanaPrincipal;

/**
 * Controlador principal del patrón MVC encargado de coordinar la interacción entre la vista {@link vista.VentanaPrincipal} y el modelo {@link modelo.EmpleadoDAO}
 * @author xaime
 * @since 24/10/2025
 */
public class QuerysController {
    
    private VentanaPrincipal vista;
    private EmpleadoDAO dao;
    
    public QuerysController(VentanaPrincipal vista, EmpleadoDAO dao) {
        
        this.vista = vista;
        this.dao = dao;
        
        try {
            
        onInsertList();
    
        } catch (SQLException e) {
            
        JOptionPane.showMessageDialog(vista, "Error al cargar listas: " + e.getMessage(), "Error de BD", JOptionPane.ERROR_MESSAGE);
    
        }
        
        this.vista.getBtnBuscar().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                onBuscar();
                
            }
            
        });
        
    }
    
    /**
     * Método encargado de insertar tuplas de la base de datos como filas en la tabla de la VentanaPrincipal
     */
    private void onBuscar() {
        
        String localidad = vista.getTfLocalidad().getText().strip();
        String oficio = vista.getTfOficio().getText().strip();

        if (localidad.isEmpty() || oficio.isEmpty()) {
            
            JOptionPane.showMessageDialog(vista, "Rellena ambos campos.");
            
            return;
            
        }
        
        try {
            
            var empleados = dao.busquedaEmpleadosPorLocalidadYOficio(localidad, oficio);

            DefaultTableModel model = (DefaultTableModel) vista.getJtEmpleados().getModel();
            model.setRowCount(0); // Limpia la tabla

            for (var e : empleados) {
                
                model.addRow( new Object[]{e.getId(), e.getApellido(), e.getOficio(), e.getDir(), e.getFechaAlta(), e.getSalario(), e.getComision(), e.getDept_no() });
            
            }

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(vista, "Error al buscar empleados: " + ex.getMessage(), "Error de BD", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    private void onInsertList() throws SQLException {
        
        DefaultListModel<String> modeloLocalidades = new DefaultListModel<>();
        
        for(String localidad : dao.busquedaLocalidades()) {
            
            modeloLocalidades.addElement(localidad);
            
        }
        
        vista.getListLocalidades().setModel(modeloLocalidades);
        
        DefaultListModel<String> modeloOficios = new DefaultListModel<>();
        
        for(String oficio : dao.busquedaOficios()) {
            
            modeloOficios.addElement(oficio);
            
        }
        
        vista.getListOficios().setModel(modeloOficios);
        
    }
    
}
