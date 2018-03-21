/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaddemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mijanur
 */
@Entity
@Table(name ="model")
public class Model {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String report_name;
    private String date_of_query;
    private String CIB_subject_code;
    private String legal_form;
    private String trade_name;
    private String TIN;
    private String telephone_number;
    private String type_of_subject;
    private String main_address;
    private String main_district;
    private String addl_address;
    private String addl_district;
    private String hist_main_address;
    private String hist_main_district;
    private String inq_CIB_subject_code;
    private String total_outstanding_amt;
    private String total_classified_outstanding_amt;
    private String num_living_facs;
    private String num_reporting_institutes;
    private String num_classified_contacts;
    private String num_stay_order_contract;
    private String num_part_institutes;
    private String title;
    private String name;
    private String father_name;
    private String mother_name;
    private String husband_name;
    private String national_ID_num;
    private String date_of_birth;
    private String gender;
    private String dist_city_birth;
    private String country_birth;
    private String postcode_main;
    private String postcode_add;

    public Model() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReport_name() {
        return report_name;
    }

    public void setReport_name(String report_name) {
        this.report_name = report_name;
    }

    public String getDate_of_query() {
        return date_of_query;
    }

    public void setDate_of_query(String date_of_query) {
        this.date_of_query = date_of_query;
    }

    public String getCIB_subject_code() {
        return CIB_subject_code;
    }

    public void setCIB_subject_code(String CIB_subject_code) {
        this.CIB_subject_code = CIB_subject_code;
    }

    public String getLegal_form() {
        return legal_form;
    }

    public void setLegal_form(String legal_form) {
        this.legal_form = legal_form;
    }

    public String getTrade_name() {
        return trade_name;
    }

    public void setTrade_name(String trade_name) {
        this.trade_name = trade_name;
    }

    public String getTIN() {
        return TIN;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getType_of_subject() {
        return type_of_subject;
    }

    public void setType_of_subject(String type_of_subject) {
        this.type_of_subject = type_of_subject;
    }

    public String getMain_address() {
        return main_address;
    }

    public void setMain_address(String main_address) {
        this.main_address = main_address;
    }

    public String getMain_district() {
        return main_district;
    }

    public void setMain_district(String main_district) {
        this.main_district = main_district;
    }

    public String getAddl_address() {
        return addl_address;
    }

    public void setAddl_address(String addl_address) {
        this.addl_address = addl_address;
    }

    public String getAddl_district() {
        return addl_district;
    }

    public void setAddl_district(String addl_district) {
        this.addl_district = addl_district;
    }

    public String getHist_main_address() {
        return hist_main_address;
    }

    public void setHist_main_address(String hist_main_address) {
        this.hist_main_address = hist_main_address;
    }

    public String getHist_main_district() {
        return hist_main_district;
    }

    public void setHist_main_district(String hist_main_district) {
        this.hist_main_district = hist_main_district;
    }

    public String getInq_CIB_subject_code() {
        return inq_CIB_subject_code;
    }

    public void setInq_CIB_subject_code(String inq_CIB_subject_code) {
        this.inq_CIB_subject_code = inq_CIB_subject_code;
    }

    public String getTotal_outstanding_amt() {
        return total_outstanding_amt;
    }

    public void setTotal_outstanding_amt(String total_outstanding_amt) {
        this.total_outstanding_amt = total_outstanding_amt;
    }

    public String getTotal_classified_outstanding_amt() {
        return total_classified_outstanding_amt;
    }

    public void setTotal_classified_outstanding_amt(String total_classified_outstanding_amt) {
        this.total_classified_outstanding_amt = total_classified_outstanding_amt;
    }

    public String getNum_living_facs() {
        return num_living_facs;
    }

    public void setNum_living_facs(String num_living_facs) {
        this.num_living_facs = num_living_facs;
    }

    public String getNum_reporting_institutes() {
        return num_reporting_institutes;
    }

    public void setNum_reporting_institutes(String num_reporting_institutes) {
        this.num_reporting_institutes = num_reporting_institutes;
    }

    public String getNum_classified_contacts() {
        return num_classified_contacts;
    }

    public void setNum_classified_contacts(String num_classified_contacts) {
        this.num_classified_contacts = num_classified_contacts;
    }

    public String getNum_stay_order_contract() {
        return num_stay_order_contract;
    }

    public void setNum_stay_order_contract(String num_stay_order_contract) {
        this.num_stay_order_contract = num_stay_order_contract;
    }

    public String getNum_part_institutes() {
        return num_part_institutes;
    }

    public void setNum_part_institutes(String num_part_institutes) {
        this.num_part_institutes = num_part_institutes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getHusband_name() {
        return husband_name;
    }

    public void setHusband_name(String husband_name) {
        this.husband_name = husband_name;
    }

    public String getNational_ID_num() {
        return national_ID_num;
    }

    public void setNational_ID_num(String national_ID_num) {
        this.national_ID_num = national_ID_num;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDist_city_birth() {
        return dist_city_birth;
    }

    public void setDist_city_birth(String dist_city_birth) {
        this.dist_city_birth = dist_city_birth;
    }

    public String getCountry_birth() {
        return country_birth;
    }

    public void setCountry_birth(String country_birth) {
        this.country_birth = country_birth;
    }

    public String getPostcode_main() {
        return postcode_main;
    }

    public void setPostcode_main(String postcode_main) {
        this.postcode_main = postcode_main;
    }

    public String getPostcode_add() {
        return postcode_add;
    }

    public void setPostcode_add(String postcode_add) {
        this.postcode_add = postcode_add;
    }

    @Override
    public String toString() {
        return "Model{" + "report_name=" + report_name + ", date_of_query=" + date_of_query + ", CIB_subject_code=" + CIB_subject_code + ", legal_form=" + legal_form + ", trade_name=" + trade_name + ", TIN=" + TIN + ", telephone_number=" + telephone_number + ", type_of_subject=" + type_of_subject + ", main_address=" + main_address + ", main_district=" + main_district + ", addl_address=" + addl_address + ", addl_district=" + addl_district + ", hist_main_address=" + hist_main_address + ", hist_main_district=" + hist_main_district + ", inq_CIB_subject_code=" + inq_CIB_subject_code + ", total_outstanding_amt=" + total_outstanding_amt + ", total_classified_outstanding_amt=" + total_classified_outstanding_amt + ", num_living_facs=" + num_living_facs + ", num_reporting_institutes=" + num_reporting_institutes + ", num_classified_contacts=" + num_classified_contacts + ", num_stay_order_contract=" + num_stay_order_contract + ", num_part_institutes=" + num_part_institutes + ", title=" + title + ", name=" + name + ", father_name=" + father_name + ", mother_name=" + mother_name + ", husband_name=" + husband_name + ", national_ID_num=" + national_ID_num + ", date_of_birth=" + date_of_birth + ", gender=" + gender + ", dist_city_birth=" + dist_city_birth + ", country_birth=" + country_birth + ", postcode_main=" + postcode_main + ", postcode_add=" + postcode_add + '}';
    }
    
    
}
