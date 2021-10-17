/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class StudentDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        
        
        String derbyClientDriver = "org.apache.derby.jdbc.ClientDriver";
        Class.forName(derbyClientDriver);
        String url = "jdbc:derby://localhost:1527/student";
        String user = "app";
        String pass = "app";
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement stmt = con.createStatement();
        
//        Student std1 = new Student(1,"Frank",3.63);
        Student std2 = new Student(2,"Celine",3.80);
        
//        insertStudent(stmt,std1);
        insertStudent(stmt,std2);
//        ArrayList<Student> studentList = getAllStudent(con);
//        printAllStudent(studentList);
//        System.out.println("");
//        Student std = getStudentById(stmt, 2);
//        std.setGpa(3.90);
//        updateStudentGPA(stmt,std);
//        deleteStudent(stmt,std);
        
        ArrayList<Student> studentList1 = getAllStudent(con);
        printAllStudent(studentList1);
        
        
        
        
        stmt.close();
        con.close();
        
    }
    
    public static void insertStudent(Statement stmt, Student std) throws SQLException{
        String sql = "insert into student (id,name,gpa)" + "values ("+ std.getId()+ ", '"+ std.getName() + "' ,"+std.getGpa() + ")";
        
        int result = stmt.executeUpdate(sql);
        System.out.println("Insert "+ result +" row");
    }
    
    public static void deleteStudent(Statement stmt, Student std)throws SQLException{
        String sql = "delete from student where id = " + std.getId();
        int result = stmt.executeUpdate(sql);
        
        System.out.println("delete " + result + " row");
    }
    
    public static void updateStudentName(Statement stmt, Student std) throws SQLException {
       String sql = "update student set name  = '" + std.getName() + "'" + " where id = " + std.getId();
       int result = stmt.executeUpdate(sql);
        //display result
        System.out.println("update " + result + " row");
   }
       
    public static void updateStudentGPA(Statement stmt, Student std) throws SQLException {
       String sql = "update student set gpa  = " + std.getGpa() + " where id = " + std.getId();
       int result = stmt.executeUpdate(sql);
        //display result
        System.out.println("update " + result + " row");
   }
    
    public static Student getStudentById(Statement stmt, int id) throws SQLException {
       Student std = null;
       String sql = "select * from student where id = " + id;
       ResultSet rs = stmt.executeQuery(sql);
       if (rs.next()) {
           std = new Student();
           std.setId(rs.getInt("id"));
           std.setName(rs.getString("name"));
           std.setGpa(rs.getDouble("gpa"));
       }
       return std;
   }
   
    public static void printAllStudent(ArrayList<Student> studentList) {
        for(Student emp : studentList) {
           System.out.print(emp.getId() + " ");
           System.out.print(emp.getName() + " ");
           System.out.println(emp.getGpa() + " ");
       }
    }
    
    public static ArrayList<Student> getAllStudent (Connection con) throws SQLException {
        String sql = "select * from student order by id";
        PreparedStatement ps = con.prepareStatement(sql);
        ArrayList<Student> studentList = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
           Student student = new Student();
           student.setId(rs.getInt("id"));
           student.setName(rs.getString("name"));
           student.setGpa(rs.getDouble("gpa"));
           studentList.add(student);
       }
       rs.close();
       return studentList;
       
    }
}
