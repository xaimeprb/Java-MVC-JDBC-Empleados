package modelo;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import utils.Conversor;

/**
 * Clase que representa la entidad Empleado dentro del modelo de datos, cada instancia de esta clase corresponde a una tupla
 * de la tabla empleados en la base de datos bd_empleados
 * @author xaime
 * @since 24/10/2025
 */
public class Empleado {
    
    private int id;
    private String apellido;
    private String oficio;
    private int dir;
    private LocalDateTime fechaAlta;
    private int salario;
    private int comision;
    private int dept_no;

    public Empleado(int id, String apellido, String oficio, int dir, LocalDateTime fechaAlta, int salario, int comision, int dept_no) {
        
        this.id = id;
        this.apellido = apellido;
        this.oficio = oficio;
        this.dir = dir;
        this.fechaAlta = fechaAlta;
        this.salario = salario;
        this.comision = comision;
        this.dept_no = dept_no;
        
    }
    
    public Empleado(int id, String apellido, String oficio, int dir, Timestamp fechaSinTransformar, int salario, int comision, int dept_no) {
        
        var conversor = new Conversor();
        
        LocalDateTime fechaTransformada = conversor.convTimestamp2LocalDateTime(fechaSinTransformar);
        
        this.id = id;
        this.apellido = apellido;
        this.oficio = oficio;
        this.dir = dir;
        setFechaAlta(fechaTransformada);
        this.salario = salario;
        this.comision = comision;
        this.dept_no = dept_no;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", apellido=" + apellido + ", oficio=" + oficio + ", dir=" + dir + ", fechaAlta=" + fechaAlta + ", salario=" + salario + ", comision=" + comision + ", dept_no=" + dept_no + '}';
    }
    
}
