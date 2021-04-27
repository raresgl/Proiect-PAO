package medical_appointment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFileService {


    private static ReadFileService instance;

    public static ReadFileService getInstance()
    {
        if (instance == null)
            instance = new ReadFileService();
        return instance;
    }


    public List<Cabinet> readCabinete(String path)
    {
        List<Cabinet> cabinete = new ArrayList<>();

        String csvFile = path;
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                var element = line.split(",");
                String adresa = element[0];
                String nume = element[1];
                Cabinet cabinet = new Cabinet(nume,adresa);
                    cabinete.add(cabinet);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cabinete;
    }



    public List<Receptionist> readReceptionisti(String path, List<Cabinet> cabinete)
    {
        List<Receptionist> receptionisti = new ArrayList<>();

        String csvFile = path;
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                var element = line.split(",");
                String nume = element[0];
                Integer salariu = Integer.parseInt(element[1]);
                String numeCabinet = element[2];

                Cabinet cabinet = null;
                for (var t : cabinete)
                {
                    if (t.getNumeCabinet().equals(numeCabinet))
                    {
                        cabinet = t;
                        break;
                    }
                }

                Receptionist receptionist = new Receptionist(nume, salariu, cabinet);
                receptionisti.add(receptionist);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return receptionisti;
    }


    public List<Pacient> readPacienti(String path)
    {
        List<Pacient> pacienti = new ArrayList<>();

        String csvFile = path;
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                var element = line.split(",");
                String nume = element[0];
                String orasDomiciliu = element[1];


                Pacient pacient = new Pacient(nume, orasDomiciliu);
                pacienti.add(pacient);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pacienti;
    }


    public List<ServiciuMedical> readServiciiMedicale(String path)
    {
        List<ServiciuMedical> serviciiMedicale = new ArrayList<>();

        String csvFile = path;
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                var element = line.split(",");
                String numeServiciu = element[0];
                Integer cost = Integer.parseInt(element[1]);

                ServiciuMedical serviciuMedical = new ServiciuMedical(cost, numeServiciu);
                serviciiMedicale.add(serviciuMedical);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return serviciiMedicale;
    }

    public List<Medic> readMedici(String path, List<Cabinet> cabinete, List<ServiciuMedical> serviciiMedicale)
    {
        List<Medic> medici = new ArrayList<>();

        String csvFile = path;
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                var element = line.split(",");
                String nume = element[0];
                Integer salariu = Integer.parseInt(element[1]);
                Integer nrCabinete = Integer.parseInt(element[2]);
                Set<Cabinet> cabineteMedic = new HashSet<>();
                for(var i=3;i < nrCabinete+3;i++)
                {
                    String numeCabinet = element[i];
                    for (var t : cabinete) {
                        if (t.getNumeCabinet().equals(numeCabinet)) {
                            cabineteMedic.add(t);
                            break;
                        }
                    }

                }
                Integer nrServicii = Integer.parseInt(element[nrCabinete+3]);
                Integer indexCurent = nrCabinete + 4;
                Set<ServiciuMedical> serviciiMedic = new HashSet<>();
                for(var i=indexCurent;i < nrServicii + indexCurent; i++ )
                {
                    String numeServiciuMedical = element[i];
                    for (var t : serviciiMedicale) {
                        if (t.getNumeServiciuMedical().equals(numeServiciuMedical)) {
                            serviciiMedic.add(t);
                            break;
                        }
                    }
                }


                Medic medic = new Medic(nume, salariu, cabineteMedic, serviciiMedic);
                medici.add(medic);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return medici;
    }


    public List<Programare> readProgramari(
            String path, List<Medic> medici, List<Pacient> pacienti, List<Receptionist> receptionisti,
            List<ServiciuMedical> serviciiMedicale)
    {
        List<Programare> programari = new ArrayList<>();

        String csvFile = path;
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                var element = line.split(",");
                String numePacient = element[0];
                String numeReceptionist = element[1];
                String numeMedic = element[2];
                String numeServiciuMedical = element[3];

                Medic medic = null;
                Pacient pacient = null;
                Receptionist receptionist = null;
                ServiciuMedical serviciuMedical = null;

                for(var t : medici)
                {
                    if(t.getNume().equals(numeMedic))
                    {
                        medic = t;
                        break;
                    }
                }

                for(var t : pacienti)
                {
                    if(t.getNume().equals(numePacient))
                    {
                        pacient = t;
                        break;
                    }
                }

                for(var t : receptionisti)
                {
                    if(t.getNume().equals(numeReceptionist))
                    {
                        receptionist = t;
                        break;
                    }
                }

                for(var t: serviciiMedicale)
                {
                    if(t.getNumeServiciuMedical().equals(numeServiciuMedical))
                    {
                        serviciuMedical = t;
                        break;
                    }
                }


                Programare programare = new Programare(medic, pacient, receptionist, serviciuMedical);

                pacient.adaugaProgramare(programare);
                receptionist.adaugaProgramare(programare);
                medic.adaugaProgramare(programare);


                programari.add(programare);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return programari;
    }






}
