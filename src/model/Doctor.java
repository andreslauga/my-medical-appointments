package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    private String speciality;
    private ArrayList<AvailableAppointments> availableAppointments = new ArrayList<>();


    public Doctor(String name, String email) {
        super(name, email);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void addAvailableAppointments(String date, String time){
        availableAppointments.add(new AvailableAppointments(date, time));
    }

    public ArrayList<AvailableAppointments> getAvailableAppointments(){
        return  availableAppointments;
    }

    @Override
    public void showDataUser() {
        System.out.println("Htal: cruz roja");
    }

    public static class AvailableAppointments {
        private int idAvailableApointments;
        private Date date;
        private String time;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");

        public  AvailableAppointments(String date, String time) {
            try {
                this.date = simpleDateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getIdAvailableApointments() {
            return idAvailableApointments;
        }

        public void setIdAvailableApointments(int idAvailableApointments) {
            this.idAvailableApointments = idAvailableApointments;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate() {
            return simpleDateFormat.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}


