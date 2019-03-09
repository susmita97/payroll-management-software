/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainfolder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author susmita
 */
public class RunSetupClass {
    
        public static Connection runSetupDBConnect() throws ClassNotFoundException, SQLException
    {
        
        Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","susmita12");
	System.out.println("Connection Established");
        
        //LOGINCREDENTIALS DATABSE
        
        PreparedStatement createdb1=con.prepareCall("create database LOGINCREDENTIALS");
        createdb1.execute();
        PreparedStatement usedb1=con.prepareCall("use LOGINCREDENTIALS");
        usedb1.execute();
        PreparedStatement admintable=con.prepareCall("create table ADMINCREDENTIALS(username varchar(50),password varchar(50),employee_id varchar(20))");
        admintable.execute();
        PreparedStatement chairptable=con.prepareCall("create table CHAIRPERSONCREDENTIALS(username varchar(50),password varchar(50),employee_id varchar(20))");
        chairptable.execute();
        PreparedStatement managertable=con.prepareCall("create table MANAGERCREDENTIALS(username varchar(50),password varchar(50),employee_id varchar(20))");
        managertable.execute();
        PreparedStatement employeetable=con.prepareCall("create table EMPLOYEECREDENTIALS(username varchar(50),password varchar(50),employee_id varchar(20))");
        employeetable.execute();
        
        //ADMINISTRATOR DATABASE
        
        PreparedStatement createdb2=con.prepareCall("create database ADMINISTRATOR");
        createdb2.execute();
        PreparedStatement usedb2=con.prepareCall("use ADMINISTRATOR");
        usedb2.execute();
        PreparedStatement adpersonal=con.prepareCall("create table PERSONALDETAILS(name varchar(100),employee_id varchar(20),job_type varchar(20),address varchar(100),pincode int(15),state varchar(20),nationality varchar(20),date_of_birth date,age int(5),blood_group varchar(5),gender varchar(10),contact_no double,emergency_contact_no double,email varchar(50),department_name varchar(10),primary key(employee_id))");
        adpersonal.execute();
        PreparedStatement adjob=con.prepareCall("create table JOBDETAILS(employee_id varchar(20),job_title varchar(20),job_description varchar(100),department_name varchar(20),department_id varchar(10),qualification varchar(50),notable_achievements varchar(100),foreign key(employee_id) references PERSONALDETAILS(employee_id) on update cascade)");
        adjob.execute();
        PreparedStatement adsalary=con.prepareCall("create table SALARYDETAILS(employee_id varchar(20),name varchar(100),department_name varchar(10),basic_salary double,dearness double,houserent double,medical double,other double,provident_fund double,professional_tax double,tax_deducted_at_source double,total_allowances double,total_deductions double,net_salary double,gross_salary double,foreign key(employee_id) references PERSONALDETAILS(employee_id) on update cascade)");
        adsalary.execute();
        PreparedStatement adleave=con.prepareCall("create table LEAVEDETAILS(employee_id varchar(20),leavetype varchar(20),days int(10),date1 date,date2 date,leave_permitted_for varchar(15),leave_remaining_for varchar(15),leave_limit_exceeded_for varchar(15),deduction varchar(5),amount double,foreign key(employee_id) references PERSONALDETAILS(employee_id) on update cascade)");
        adleave.execute();
        
        //CHAIRPERSON DATABASE
        
        PreparedStatement createdb3=con.prepareCall("create database CHAIRPERSON");
        createdb3.execute();
        PreparedStatement usedb3=con.prepareCall("use CHAIRPERSON");
        usedb3.execute();
        PreparedStatement chpersonal=con.prepareCall("create table PERSONALDETAILS(name varchar(100),employee_id varchar(20),job_type varchar(20),address varchar(100),pincode int(15),state varchar(20),nationality varchar(20),date_of_birth date,age int(5),blood_group varchar(5),gender varchar(10),contact_no double,emergency_contact_no double,email varchar(50),department_name varchar(10),primary key(employee_id))");
        chpersonal.execute();
        PreparedStatement chjob=con.prepareCall("create table JOBDETAILS(employee_id varchar(20),job_title varchar(20),job_description varchar(100),department_name varchar(20),department_id varchar(10),qualification varchar(50),notable_achievements varchar(100),foreign key(employee_id) references PERSONALDETAILS(employee_id) on update cascade)");
        chjob.execute();
        PreparedStatement chsalary=con.prepareCall("create table SALARYDETAILS(employee_id varchar(20),name varchar(100),department_name varchar(10),basic_salary double,dearness double,houserent double,medical double,other double,provident_fund double,professional_tax double,tax_deducted_at_source double,total_allowances double,total_deductions double,net_salary double,gross_salary double,foreign key(employee_id) references PERSONALDETAILS(employee_id) on update cascade)");
        chsalary.execute();
        PreparedStatement chleave=con.prepareCall("create table LEAVEDETAILS(employee_id varchar(20),leavetype varchar(20),days int(10),date1 date,date2 date,leave_permitted_for varchar(15),leave_remaining_for varchar(15),leave_limit_exceeded_for varchar(15),deduction varchar(5),amount double,foreign key(employee_id) references PERSONALDETAILS(employee_id) on update cascade)");
        chleave.execute();
        
        //MANAGER EMPLOYEE
        
        PreparedStatement createdb4=con.prepareCall("create database MANAGER");
        createdb4.execute();
        PreparedStatement usedb4=con.prepareCall("use MANAGER");
        usedb4.execute();
        PreparedStatement managerpersonal=con.prepareCall("create table PERSONALDETAILS(name varchar(100),employee_id varchar(20),job_type varchar(20),address varchar(100),pincode int(15),state varchar(20),nationality varchar(20),date_of_birth date,age int(5),blood_group varchar(5),gender varchar(10),contact_no double,emergency_contact_no double,email varchar(50),department_name varchar(10),primary key(employee_id))");
        managerpersonal.execute();
        PreparedStatement managerjob=con.prepareCall("create table JOBDETAILS(employee_id varchar(20),job_title varchar(20),job_description varchar(100),department_name varchar(20),department_id varchar(10),qualification varchar(50),notable_achievements varchar(100),foreign key(employee_id) references PERSONALDETAILS(employee_id) on update cascade)");
        managerjob.execute();
        PreparedStatement managersalary=con.prepareCall("create table SALARYDETAILS(employee_id varchar(20),name varchar(100),department_name varchar(10),basic_salary double,dearness double,houserent double,medical double,other double,provident_fund double,professional_tax double,tax_deducted_at_source double,total_allowances double,total_deductions double,net_salary double,gross_salary double,foreign key(employee_id) references PERSONALDETAILS(employee_id) on update cascade)");
        managersalary.execute();
        PreparedStatement managerleave=con.prepareCall("create table LEAVEDETAILS(employee_id varchar(20),leavetype varchar(20),days int(10),date1 date,date2 date,leave_permitted_for varchar(15),leave_remaining_for varchar(15),leave_limit_exceeded_for varchar(15),deduction varchar(5),amount double,foreign key(employee_id) references PERSONALDETAILS(employee_id) on update cascade)");
        managerleave.execute();
        
        //EMPLOYEE DATABASE
        
        PreparedStatement createdb5=con.prepareCall("create database EMPLOYEE");
        createdb5.execute();
        PreparedStatement usedb5=con.prepareCall("use EMPLOYEE");
        usedb5.execute();
        PreparedStatement empersonal=con.prepareCall("create table PERSONALDETAILS(name varchar(100),employee_id varchar(20),job_type varchar(20),address varchar(100),pincode int(15),state varchar(20),nationality varchar(20),date_of_birth date,age int(5),blood_group varchar(5),gender varchar(10),contact_no double,emergency_contact_no double,email varchar(50),department_name varchar(10),primary key(employee_id))");
        empersonal.execute();
        PreparedStatement emjob=con.prepareCall("create table JOBDETAILS(employee_id varchar(20),job_title varchar(20),job_description varchar(100),department_name varchar(20),department_id varchar(10),qualification varchar(50),notable_achievements varchar(100),foreign key(employee_id) references PERSONALDETAILS(employee_id) on update cascade)");
        emjob.execute();
        PreparedStatement emsalary=con.prepareCall("create table SALARYDETAILS(employee_id varchar(20),name varchar(100),department_name varchar(10),basic_salary double,dearness double,houserent double,medical double,other double,provident_fund double,professional_tax double,tax_deducted_at_source double,total_allowances double,total_deductions double,net_salary double,gross_salary double,foreign key(employee_id) references PERSONALDETAILS(employee_id) on update cascade)");
        emsalary.execute();
        PreparedStatement emleave=con.prepareCall("create table LEAVEDETAILS(employee_id varchar(20),leavetype varchar(20),days int(10),date1 date,date2 date,leave_permitted_for varchar(15),leave_remaining_for varchar(15),leave_limit_exceeded_for varchar(15),deduction varchar(5),amount double,foreign key(employee_id) references PERSONALDETAILS(employee_id) on update cascade)");
        emleave.execute();
        
       
        System.out.println("Db created");
        con.close();
        return con;
        
    }
    
}
