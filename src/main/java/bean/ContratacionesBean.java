package bean;


import java.util.Date;

public class ContratacionesBean {

    private int idContratacion;
    private EmpleadoBean empleadoBean;
    private DepartamentoBean departamentoBean;
    private CargoBean cargoBean;
    private TipoContratacionBean tipoContratacionBean;
    private Date fechaContratacion;
    private double salario;
    private boolean estado;


    public ContratacionesBean() {
    }

    public ContratacionesBean(EmpleadoBean empleadoBean, DepartamentoBean departamentoBean, CargoBean cargoBean, TipoContratacionBean tipoContratacionBean, Date fechaContratacion, double salario, boolean estado) {
        this.empleadoBean = empleadoBean;
        this.departamentoBean = departamentoBean;
        this.cargoBean = cargoBean;
        this.tipoContratacionBean = tipoContratacionBean;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
        this.estado = estado;
    }

    public ContratacionesBean(int idContratacion, EmpleadoBean empleadoBean, DepartamentoBean departamentoBean, CargoBean cargoBean, TipoContratacionBean tipoContratacionBean, Date fechaContratacion, double salario, boolean estado) {
        this.idContratacion = idContratacion;
        this.empleadoBean = empleadoBean;
        this.departamentoBean = departamentoBean;
        this.cargoBean = cargoBean;
        this.tipoContratacionBean = tipoContratacionBean;
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

    public EmpleadoBean getEmpleado() {
        return empleadoBean;
    }

    public void setEmpleado(EmpleadoBean empleadoBean) {
        this.empleadoBean = empleadoBean;
    }

    public DepartamentoBean getDepartamento() {
        return departamentoBean;
    }

    public void setDepartamento(DepartamentoBean departamentoBean) {
        this.departamentoBean = departamentoBean;
    }

    public CargoBean getCargo() {
        return cargoBean;
    }

    public void setCargo(CargoBean cargoBean) {
        this.cargoBean = cargoBean;
    }

    public TipoContratacionBean getTipoContratacion() {
        return tipoContratacionBean;
    }

    public void setTipoContratacion(TipoContratacionBean tipoContratacionBean) {
        this.tipoContratacionBean = tipoContratacionBean;
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
