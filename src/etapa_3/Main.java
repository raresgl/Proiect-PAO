package etapa_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String host = "jdbc:mysql://localhost:3306/medicalappointmentDB";
        String username = "root";
        String pass = "rares";
        

        Scanner scanner = new Scanner(System.in);
        Integer input = 111;
        while(input != 0 )
        {
            System.out.println("Alegeti o optiune:");
            System.out.println("1. Create cabinet");
            System.out.println("2. Create Receptionist");
            System.out.println("3. Create pacient");
            System.out.println("4. Create serviciu medical");
            System.out.println("5. Create Programare");
            System.out.println("6. Create medic");
            System.out.println("7. ShowMediciDinCabinetulDupaRecenzii");
            System.out.println("8. ShowServiciiDinCabinet");
            System.out.println("9. ShowTotalSalariiCabinet");
            System.out.println("10. Create recenzie");
            System.out.println("0. Exit program");
            input = Integer.parseInt(scanner.nextLine());
            switch(input)
            {
                case 1:


            }
        }


        }

    }
