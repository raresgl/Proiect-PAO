package etapa_1;
import java.util.*;

// clasa medic va fi o subclasa a superclasei angajat
public class Medic extends Angajat{
    Set<Cabinet> listaCabineteAdministrate = new HashSet<>();
    Set<ServiciuMedical> serviciiMedicalePrestate = new HashSet<>();
    List<Programare> listaProgramari = new ArrayList<>();
    Set<Recenzie> listaRecenziiPrimite = new HashSet<>();
    public Medic(String nume, Integer salariu,
                 Set<Cabinet> listaCabineteAdministrate, Set<ServiciuMedical> serviciiMedicalePrestate) {
        this.nume =nume;
        this.salariu = salariu;
        this.listaCabineteAdministrate = listaCabineteAdministrate;
        this.serviciiMedicalePrestate = serviciiMedicalePrestate;
        for(var cabinet : listaCabineteAdministrate)
            cabinet.adaugaAngajat((this));

    }

    void adaugaProgramare(Programare programare)
    {
        listaProgramari.add(programare);
    }

    Float getMediaRecenziilor()
    {
        if (listaRecenziiPrimite.size() == 0)
            return 0.0f;
        else
        {
            Float sum = 0.0f;
            for(var i : listaRecenziiPrimite)
                sum += i.getNota();
            return (sum / listaRecenziiPrimite.size());
        }
    }


    public static Comparator<Medic> SortareDupaRecenzii = new Comparator<Medic>() {
        @Override
        public int compare(Medic o1, Medic o2) {
            return Math.round(o2.getMediaRecenziilor() - o1.getMediaRecenziilor());
        }
    };




    void adaugaRecenzie(Recenzie recenzie)
    {
        listaRecenziiPrimite.add(recenzie);
    }

    public List<Programare> getListaProgramari() {
        return listaProgramari;
    }

    public void setListaProgramari(List<Programare> listaProgramari) {
        this.listaProgramari = listaProgramari;
    }
    public Set<Recenzie> getListaRecenziiPrimite() {
        return listaRecenziiPrimite;
    }

    public void setListaRecenziiPrimite(Set<Recenzie> listaRecenziiPrimite) {
        this.listaRecenziiPrimite = listaRecenziiPrimite;
    }

    void adaugaServiciu(ServiciuMedical serviciuMedical)
    {
        serviciiMedicalePrestate.add((serviciuMedical));
    }

    public void setListaCabineteAdministrate(Set<Cabinet> listaCabineteAdministrate) {
        this.listaCabineteAdministrate = listaCabineteAdministrate;
    }

    void adaugaCabinet(Cabinet cabinet)
    {
        listaCabineteAdministrate.add(cabinet);
    }


    public Set<Cabinet> getListaCabineteAdministrate() {
        return listaCabineteAdministrate;
    }

    public Set<ServiciuMedical> getServiciiMedicalePrestate() {
        return serviciiMedicalePrestate;
    }

    public void setServiciiMedicalePrestate(Set<ServiciuMedical> serviciiMedicalePrestate) {
        this.serviciiMedicalePrestate = serviciiMedicalePrestate;
    }
}
