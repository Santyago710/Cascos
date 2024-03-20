import java.util.List;

abstract class CascoFactory {
    public abstract Casco crearCasco(List<String> accesorios);
}

class CascoFactoryBasico extends CascoFactory {
    @Override
    public Casco crearCasco(List<String> accesorios) {
        AccesoriosCascoBasico accesoriosBasico = new AccesoriosCascoBasico();
        for (String accesorio : accesorios) {
            accesoriosBasico.agregarAccesorio(accesorio);
        }
        return new CascoBasico(accesoriosBasico);
    }
}

class CascoFactoryPremium extends CascoFactory {
    @Override
    public Casco crearCasco(List<String> accesorios) {
        AccesoriosCascoPremium accesoriosPremium = new AccesoriosCascoPremium();
        for (String accesorio : accesorios) {
            accesoriosPremium.agregarAccesorio(accesorio);
        }
        return new CascoPremium(accesoriosPremium);
    }
}

class CascoFactoryStandard extends CascoFactory {
    @Override
    public Casco crearCasco(List<String> accesorios) {
        AccesoriosCascoStandard accesoriosStandard = new AccesoriosCascoStandard();
        for (String accesorio : accesorios) {
            accesoriosStandard.agregarAccesorio(accesorio);
        }
        return new CascoStandard(accesoriosStandard);
    }
}

