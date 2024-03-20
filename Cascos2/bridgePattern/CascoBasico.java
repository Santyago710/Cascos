// Refined Abstraction 1
class CascoBasico extends Casco {
    public CascoBasico(AccesoriosCasco accesorios) {
        super(accesorios);
    }

    @Override
    public String ensamblar() {
        return accesorios.agregarAccesorios();
    }
}