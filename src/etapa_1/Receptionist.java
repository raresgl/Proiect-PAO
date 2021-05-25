package etapa_1;
import java.util.ArrayList;
import java.util.List;

public class Receptionist extends Angajat {
    private List<Programare> listaProgramari = new ArrayList<>();
    private Cabinet cabinet;

    public Receptionist(String nume,Integer salariu, Cabinet cabinet) {
        this.nume = nume;
        this.salariu = salariu;
        this.cabinet = cabinet;
        cabinet.adaugaAngajat(this);
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    void adaugaProgramare(Programare programare)
    {
        listaProgramari.add(programare);
    }

    public List<Programare> getListaProgramari() {
        return listaProgramari;
    }

    public void setListaProgramari(List<Programare> listaProgramari) {
        this.listaProgramari = listaProgramari;
    }


}
