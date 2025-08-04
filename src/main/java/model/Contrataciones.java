package model;


import java.util.Date;

public class Contrataciones {

    private int idContratacion;
    private Empleado empleado;
    private Departamento departamento;
    private Cargo cargo;
    private TipoContratacion tipoContratacion;
    private Date fechaContratacion;
    private double salario;
    private boolean estado;


    public Contrataciones() {
    }

    public Contrataciones(Empleado empleado, Departamento departamento, Cargo cargo, TipoContratacion tipoContratacion, Date fechaContratacion, double salario, boolean estado) {
        this.empleado = empleado;
        this.departamento = departamento;
        this.cargo = cargo;
        this.tipoContratacion = tipoContratacion;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
        this.estado = estado;
    }

    public Contrataciones(int idContratacion, Empleado empleado, Departamento departamento, Cargo cargo, TipoContratacion tipoContratacion, Date fechaContratacion, double salario, boolean estado) {
        this.idContratacion = idContratacion;
        this.empleado = empleado;
        this.departamento = departamento;
        this.cargo = cargo;
        this.tipoContratacion = tipoContratacion;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
        this.estado = estado;
    }

    public void setIdContratacion(int idContratacion) {
        this.idContratacion = idContratacion;
    }

    public int getIdContratacion() {
        return idContratacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public TipoContratacion getTipoContratacion() {
        return tipoContratacion;
    }

    public void setTipoContratacion(TipoContratacion tipoContratacion) {
        this.tipoContratacion = tipoContratacion;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
