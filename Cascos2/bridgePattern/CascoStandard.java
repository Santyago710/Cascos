// Refined Abstraction 3
class CascoStandard extends Casco {
    public CascoStandard(AccesoriosCasco accesorios) {
        super(accesorios);
    }

    @Override
    public String ensamblar() {
        return accesorios.agregarAccesorios();
    }
    }