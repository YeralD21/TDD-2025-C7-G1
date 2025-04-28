package service;

public class ServicioBImpl implements ServicioB {
private ServicioA servicioA;

    @Override
    public ServicioA getServicioA() {
        return servicioA;
    }
    @Override
    public void setServicioA(ServicioA servicioA) {
    this.servicioA = servicioA;
    }

    @Override
    public int multiplicarSumar(int i, int i1, int i2) {
        return servicioA.sumar(1,i1)*i2;
    }
    @Override
    public int multiplicar(int i, int i1) {
        return i*i1;
    }

}
