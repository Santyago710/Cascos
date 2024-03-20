// Refined Abstraction 2
class CascoPremium extends Casco {
    public CascoPremium(AccesoriosCasco accesorios) {
        super(accesorios);
    }

    @Override
    public String ensamblar() {
        return accesorios.agregarAccesorios();
    }
}