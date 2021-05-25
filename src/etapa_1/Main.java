package etapa_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        ClasaServiciu clasaServiciu = new ClasaServiciu();

        var cabinet = clasaServiciu.CreateCabinet();
        var cabinet2 = clasaServiciu.CreateCabinet();
        var receptionist = clasaServiciu.CreateReceptionist(cabinet);
        var pacient = clasaServiciu.CreatePacient();
        var pacient1 = clasaServiciu.CreatePacient();
        var serviciuMedical = clasaServiciu.CreateServiciuMedical();
        var serviciumedical2 = clasaServiciu.CreateServiciuMedical();
        var serviciumedical3= clasaServiciu.CreateServiciuMedical();
//
        Set<Cabinet> cabinete = new HashSet<Cabinet>(Arrays.asList(cabinet, cabinet2));
        Set<Cabinet> cabinete2 = new HashSet<Cabinet>(Arrays.asList(cabinet));
//
//
        var medic = clasaServiciu.CreateMedic(cabinete, new HashSet<ServiciuMedical>(Arrays.asList(serviciuMedical)));
        var medic2 = clasaServiciu.CreateMedic(cabinete2, new HashSet<ServiciuMedical>(Arrays.asList(serviciumedical3, serviciumedical2)));
//

        //var programare = clasaServiciu.CreateProgramare(medic, pacient, receptionist, serviciumedical2 );
        var programare = clasaServiciu.CreateProgramare(medic, pacient, receptionist, serviciuMedical);
        clasaServiciu.ShowTotalSalariiCabinet(cabinet);
        clasaServiciu.ShowTotalSalariiCabinet(cabinet2);

        clasaServiciu.CreateRecenzie(pacient,cabinet,medic,serviciuMedical);
        clasaServiciu.CreateRecenzie(pacient1,cabinet2,medic,serviciuMedical);

        clasaServiciu.ShowMediciDinCabinetulDupaRecenzii(cabinet);
        clasaServiciu.ShowServiciiDinCabinet(cabinet);


    }
}
