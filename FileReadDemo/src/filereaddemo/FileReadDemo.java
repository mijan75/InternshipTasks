/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaddemo;

import filereaddemo.models.Model;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Pattern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mijanur
 */
public class FileReadDemo {

    public FileReadDemo() {
        String line = null;
        boolean checkCIB = false;
        boolean checkTypeOfSubject = false;
        boolean checkNumberOfReportingInstitutes = false;
        boolean checkNumberOfStayOrder = false;
        boolean chekNumberOfLivingFacilities = false;
        Model model = new Model();

        try (RandomAccessFile randomAccessFile = new RandomAccessFile("input.txt", "rw")) {
            while ((line = randomAccessFile.readLine()) != null) {

                String[] spilt = line.split(Pattern.quote(":"));
                String[] spilt2 = line.split(", ");

                if (spilt[0].equals("Date of inquiry")) {
                    model.setDate_of_query(spilt[1] + spilt[2]);
                } else if (spilt[0].equals("Legal form")) {
                    model.setLegal_form(spilt[1]);
                } else if (spilt[0].equals("Trade name")) {
                    model.setTrade_name(spilt[1]);
                } else if (spilt[0].equals("CIB subject code") && checkCIB == false) {
                    checkCIB = true;
                    model.setCIB_subject_code(spilt[1]);
                    model.setInq_CIB_subject_code(spilt[1]);
                } else if (spilt[0].equals("Type of subject") && checkTypeOfSubject == false) {
                    checkTypeOfSubject = true;
                    model.setType_of_subject(spilt[1]);
                } else if (spilt[0].equals("Owner's National ID number")) {
                    model.setNational_ID_num(spilt[1]);
                } else if (spilt[0].equals("Owner's gender")) {
                    model.setGender(spilt[1]);
                } else if (spilt[0].equals("Owner's TIN")) {
                    model.setTIN(spilt[1]);
                } else if (spilt[0].equals("Owner's country of birth")) {
                    model.setCountry_birth(spilt[2]);
                } else if (spilt[0].equals("Owner's Title")) {
                    model.setTitle(spilt[1]);
                } else if (spilt[0].equals("Owner's name")) {
                    model.setName(spilt[1]);
                } else if (spilt[0].equals("Owner's father's name")) {
                    model.setFather_name(spilt[1]);
                } else if (spilt[0].equals("Owner's mother's name")) {
                    model.setMother_name(spilt[1]);
                } else if (spilt[0].equals("Owner's date of birth")) {
                    model.setDate_of_birth(spilt[1]);
                } else if (spilt[0].equals("Owner's district/city of birth")) {
                    model.setDist_city_birth(spilt[1]);
                } else if (spilt[0].equals("Telephone number")) {
                    model.setTelephone_number(spilt[1]);
                } else if (spilt[0].equals("Country of birth")) {
                    model.setCountry_birth(spilt[1]);
                } else if (spilt[0].equals("Title, Spouse's name")) {
                    model.setHusband_name(spilt[1]);
                } else if (spilt[0].equals("Number of reporting Institutes") && checkNumberOfReportingInstitutes == false) {
                    checkNumberOfReportingInstitutes = true;

                    String[] temp1 = spilt[1].split(" ");
                    model.setNum_reporting_institutes(temp1[1]);
                    model.setNum_part_institutes(temp1[1]);
                    model.setTotal_outstanding_amt(spilt[2]);
                } else if (spilt[0].equals("Number of Stay Order Contract") && checkNumberOfStayOrder == false) {
                    checkNumberOfStayOrder = true;
                    String[] temp = spilt[1].split(" ");
                    model.setNum_stay_order_contract(temp[1]);
                } else if (spilt[0].equals("Number of living facilities") && chekNumberOfLivingFacilities == false) {
                    chekNumberOfLivingFacilities = true;
                    String[] temp2 = spilt[1].split(" ");
                    model.setNum_living_facs(temp2[1]);
                }
                if (spilt2[0].contains("Owner's main")) {
                    checkHistMainAddress(spilt2, model);
                }

            }
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            session.save(model);
            session.getTransaction().commit();
            session.close();
            System.out.println(model.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkHistMainAddress(String spilt2[], Model model) {
        String spilt3[] = spilt2[0].split("Owner's main");
        model.setHist_main_address(spilt3[1]);
        String spilt4[] = spilt2[1].split("-");
        model.setHist_main_district(spilt4[2]);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new FileReadDemo();
    }

}
