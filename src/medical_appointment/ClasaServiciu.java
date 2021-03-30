package medical_appointment;

import java.util.*;

public class ClasaServiciu {

    public Receptionist CreateReceptionist(Cabinet cabinet)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numele receptionistului: ");
        var nume = scanner.nextLine();
        System.out.println("Salariu receptionist: ");
        Integer salariu = Integer.parseInt(scanner.nextLine());
        Receptionist receptionist = new Receptionist(nume, salariu, cabinet);
        return receptionist;
    }

    public Pacient CreatePacient()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numele pacientului");
        var nume = scanner.nextLine();
        System.out.println("Oras de domiciliu");
        var oras = scanner.nextLine();
        Pacient pacient = new Pacient(nume, oras);
        return pacient;

    }

    public Cabinet CreateCabinet()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adresa cabinetului: ");
        var adresa = scanner.nextLine();
        System.out.println("Nume cabinet");
        var nume = scanner.nextLine();
        Cabinet cabinet = new Cabinet(nume,adresa);
        return cabinet;
    }

    public ServiciuMedical CreateServiciuMedical()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nume serviciu medical:");
        var numeServiciu = scanner.nextLine();
        System.out.println("Costul serviciului medical: ");
        var cost = Integer.parseInt(scanner.nextLine());
        ServiciuMedical serviciuMedical = new ServiciuMedical(cost, numeServiciu);
        return serviciuMedical;
    }


    public Medic CreateMedic(Set<Cabinet> cabinete, Set<ServiciuMedical> servicii)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numele medicului: ");
        var nume = scanner.nextLine();
        System.out.println("Salariu medic: ");
        Integer salariu = Integer.parseInt(scanner.nextLine());
        Medic medic = new Medic(nume,salariu, cabinete, servicii);
        return medic;
    }

    public Programare CreateProgramare(Medic medic, Pacient pacient, Receptionist receptionist, ServiciuMedical serviciuMedical)
    {
        if(!medic.serviciiMedicalePrestate.contains(serviciuMedical)) {
            System.out.println("Nu putem furniza serviciul medical solicitat la programare");
            return null;
        }
        Programare programare = new Programare(medic, pacient, receptionist, serviciuMedical);
        pacient.adaugaProgramare(programare);
        receptionist.adaugaProgramare(programare);
        medic.adaugaProgramare(programare);

        return programare;
    }


    void ShowTotalSalariiCabinet(Cabinet cabinet)
    {
        var suma = 0;
        var lista = cabinet.getSetAngajati();
        for(var angajat : lista)
            suma += angajat.getSalariu();
        System.out.println("Cabinetul " + cabinet.getNumeCabinet() + " are bugetul de salarii al angajatilor de " +
                            suma + " lei ");
    }

    Recenzie CreateRecenzie(Pacient pacient, Cabinet cabinet, Medic medic, ServiciuMedical serviciu)
    {

        var scanner = new Scanner(System.in);
        var nota = 0;
        while(true)
        {
            System.out.println("Nota acordata de catre pacientul " + pacient.getNume() + " pentru serviciul " +
                    serviciu.getNumeServiciuMedical() + " acordat de medicul " + medic.getNume() +
                    " este: ");
            nota = Integer.parseInt(scanner.nextLine());
            if(nota <= 10 && nota >= 1)
                break;
        }
        Recenzie recenzie = new Recenzie(nota,pacient,medic,serviciu);
        pacient.adaugaRecenzie(recenzie);
        medic.adaugaRecenzie(recenzie);
        cabinet.adaugaRecenzie(recenzie);
        return recenzie;
    }
    void ShowMediciDinCabinetulDupaRecenzii(Cabinet c)
    {
        List<Medic> set = new ArrayList<Medic>();
        for(var angj : c.getSetAngajati())
        {
            if (angj instanceof Medic)
                set.add((Medic) angj);
        }
        Collections.sort(set, Medic.SortareDupaRecenzii);

        for( var medic : set)
        {
            System.out.println("Medicul " + medic.getNume() + " are media recenziilor " + ((Medic) medic).getMediaRecenziilor()
                + " si a servit " + ((Medic) medic).getListaProgramari().size() + " programari");
        }
    }
    void ShowServiciiDinCabinet(Cabinet c)
    {
        var angajati = c.getSetAngajati();
        Set<ServiciuMedical> servicii = new HashSet<>();
        for(var angajat : angajati)
        {
            if(angajat instanceof
            Medic)
            {
                var listaservicii = ((Medic) angajat).getServiciiMedicalePrestate();
                for(ServiciuMedical serviciu : listaservicii)
                    servicii.add(serviciu);
            }
        }
        System.out.println("Serviciile cabinetului " + c.getNumeCabinet() + " sunt: ");
        for(var serviciu : servicii)
        {
            System.out.print(serviciu.getNumeServiciuMedical() + " ");
        }
    }

}
