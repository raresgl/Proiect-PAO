package medical_appointment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cabinet {
    private String numeCabinet;
    private String adresaCabinet;
    private List<Recenzie> listaRecenzii = new ArrayList<>();
    private Set<Angajat> setAngajati = new HashSet<>();

    public Cabinet(String numeCabinet, String adresaCabinet) {
        this.numeCabinet = numeCabinet;
        this.adresaCabinet = adresaCabinet;
    }

    public void adaugaAngajat(Angajat a)
    {
        setAngajati.add(a);
    }

    //vom adauga recenziile intr-o lista de recenzii
    public void adaugaRecenzie(Recenzie recenzie)
    {
        listaRecenzii.add(recenzie);
    }

    public Set<Angajat> getSetAngajati() {
        return setAngajati;
    }

    public void setSetAngajati(Set<Angajat> setAngajati) {
        this.setAngajati = setAngajati;
    }

    public String getNumeCabinet() {
        return numeCabinet;
    }

    public void setNumeCabinet(String numeCabinet) {
        this.numeCabinet = numeCabinet;
    }

    public String getAdresaCabinet() {
        return adresaCabinet;
    }

    public void setAdresaCabinet(String adresaCabinet) {
        this.adresaCabinet = adresaCabinet;
    }

    public List<Recenzie> getListaRecenzii() {
        return listaRecenzii;
    }

    public void setListaRecenzii(List<Recenzie> listaRecenzii) {
        this.listaRecenzii = listaRecenzii;
    }
}
