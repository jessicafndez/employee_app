package dao;

//	Java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//	Hibernate
import org.hibernate.Session;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

//	Models
import model.Employee;

// This is a Dao class of employees to manage it
public class EmployeeDAO {
	private Session session;
	
	//	TODO if need it
	public EmployeeDAO(Session session) {
		this.session = session;
	}
	
	//	Current employees list from DB
	public List<Employee> listEmployees() {
		List<Employee> listEmployees = new ArrayList<Employee>();
		
		try {
			List employees = session.createQuery("FROM Employee").list(); 
			for (Iterator iterator = employees.iterator(); iterator.hasNext();){
		        Employee employee = (Employee) iterator.next(); 
		        listEmployees.add(employee);
		     }
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}

		return listEmployees;
	}
	
	//	Get employee By Id
	public Employee getEmployee(int emp_no) {
		Employee employee = new Employee();
		
		try {
			String query = "FROM employees WHERE emp_no = :id";
			employee = (Employee)session.load(Employee.class, emp_no);
			Hibernate.initialize(employee);
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	
}
