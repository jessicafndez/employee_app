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
	
	//private  employeeDao;
	
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        System.out.println("Transation start correctly");
        
        App app = new App();
        eDao = new EmployeeDAO(session);
        
        List<Employee> lEmployee = app.listEmployees(eDao);
        System.out.println(lEmployee.toString());
        
    }
    
    public List<Employee> listEmployees(EmployeeDAO eDao) {
    	List<Employee> listEmployees = new ArrayList<Employee>();
    	Transaction tx = null;
    	
		try {	
			listEmployees = eDao.listEmployees();
				
		} 
		catch(HibernateException e) {
		        if (tx!=null) tx.rollback();
		        e.printStackTrace(); 
		} 
		finally {
		        session.close(); 
		}
	
    	
    	return listEmployees;
    }
}
