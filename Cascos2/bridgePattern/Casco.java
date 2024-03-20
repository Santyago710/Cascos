// Abstraction
abstract class Casco {
    protected AccesoriosCasco accesorios;

    public Casco(AccesoriosCasco accesorios) {
        this.accesorios = accesorios;
    }

    public abstract String ensamblar();
}
