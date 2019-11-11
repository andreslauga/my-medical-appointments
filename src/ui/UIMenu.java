package ui;
import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;


    public static void showMenu() {
        System.out.println("Welcome to my appointemts");
        System.out.println("Select menu option");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Doctor");
                    authUser(1);
                    break;
                case 2:
                    System.out.println("Patient");
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Gracias por la visita ");
                    break;
                default:
                    System.out.println("Select a correct answer perra");
            }
        } while (response != 0);
    }


    private static void authUser(int userType){
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Andres","alauga@mail.com"));
        doctors.add(new Doctor("Agustina","agus@mail.com"));
        doctors.add(new Doctor("Ringo","ringo@mail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Pedro","pedro@mail.com"));
        patients.add(new Patient("Pablo","pablo@mail.com"));
        patients.add(new Patient("Patricio","patricio@mail.com"));

        boolean emailCorrect = false;

        do {
            System.out.println("Insert your email");
            Scanner scanner = new Scanner(System.in);
            String email = scanner.nextLine();
            if (userType == 1 ){
                for (Doctor doctor: doctors){
                    if (doctor.getEmail().equals(email)){
                        emailCorrect = true;
                        doctorLogged = doctor;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            } else if (userType == 2){
                for (Patient patient: patients){
                    if (patient.getEmail().equals(email)){
                        emailCorrect = true;
                        patientLogged = patient;
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }

        }while (!emailCorrect);
    }
}
