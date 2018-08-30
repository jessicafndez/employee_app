package employee_app;

import java.util.ArrayList;
import java.util.Iterator;

// Java
import java.util.List;

import org.hibernate.HibernateException;

// Hibernate
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.EmployeeDAO;

// Custom
import model.Employee;

public class App {
	private static Session session; 
	private static EmployeeDAO eDao;
	
	//If we need to ->  if (tx!=null) tx.rollback();
	private Transaction tx;
	
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        System.out.println("Transation start correctly");
        
        App app = new App();
        eDao = new EmployeeDAO(session);
        
        List<Employee> lEmployee = eDao.listEmployees();
        for(Employee e: lEmployee) {
        //	System.out.println(e.getFirst_name());
        }
        
        Employee employee = eDao.getEmployee(10006);
        //for example
        System.out.println(employee.getFirst_name());
        
        session.close();
        
    }
    
}
