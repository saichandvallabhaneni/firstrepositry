package com.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

	/*
	 * private String jdbcDriverClass = "com.mysql.cj.jdbc.Driver"; private String
	 * dbUrl = "jdbc:mysql://localHost:3306/training"; private String
	 * username="root"; private String password="root"; private Connection
	 * connection;
	 */


	private Connection connection;
	public BookDao() {
		connection = new DbConnection().getConnection();
		System.out.println(connection);
		if(connection != null)
			System.out.println("Ping Successful..");
	}
	/*
	 * public BookDao() { //step 1 load the driver try {
	 * Class.forName(jdbcDriverClass);
	 * 
	 * //step 2 get the connection
	 * 
	 * connection=DriverManager.getConnection(dbUrl,username,password);
	 * if(connection!=null) System.out.println("ping Successful");
	 * 
	 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * }
	 */


	public int addBook(Book book) {
		//step 3
		String template ="insert into book values(?,?,?,?,?)";
		try(PreparedStatement pstmt = connection.prepareStatement(template)) {
			pstmt.setLong(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setDouble(3, book.getPrice());
			pstmt.setString(4, book.getCategory());
			pstmt.setDouble(5, book.getStock());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

	}

	public List<Book> getAllBooks() 
	{ 
		String template ="select * from book"; 
		List<Book> bookList = new ArrayList<>();
		try(PreparedStatement stmt = connection.prepareStatement(template)) {

			ResultSet rs =stmt.executeQuery(); 
			while(rs.next()) 
			{ 
				Book b= new Book();
				//System.out.println(rs.getLong(1)+" "+rs.getString(2)+" "+rs.getNString(3));
				b.setIsbn(rs.getLong(1));
				b.setTitle(rs.getString(2));
				b.setPrice(rs.getDouble(3));
				b.setCategory(rs.getString(4));
				b.setStock(rs.getDouble(5));
				bookList.add(b);

			} return bookList;
		} 
		catch(SQLException e) {
			e.printStackTrace(); 
			return bookList; } 
	}



	public int deleteBook(long isbn) {

		String template="delete from book where isbn =?";
		try(PreparedStatement pstmt = connection.prepareStatement(template))
		{ 
			pstmt.setLong(1, isbn);
			return pstmt.executeUpdate(); } 

		catch (SQLException e) { e.printStackTrace();
		return -1; }

	}


	public int updateBookstock(long isbn) 
	{ 
		String template1="update book set stock=stock-1 where isbn =?";
		try(PreparedStatement pstmt = connection.prepareStatement(template1)) 
		{
			pstmt.setLong(1, isbn);

			return pstmt.executeUpdate(); } 
		catch (SQLException e) 
		{ e.printStackTrace();
		return -1; } }



	public List<Book> bookTitleSearch(String title)
	{
		String template ="select * from book where title like ?";
		List<Book> booklistsearch=new ArrayList<>();
		try(PreparedStatement pstmt=connection.prepareStatement(template))
		{
			pstmt.setString(1, "%"+title+"%");
			ResultSet rs=pstmt.executeQuery();

			while(rs.next()) 
			{ Book b=new Book();

			b.setIsbn(rs.getLong(1));
			b.setTitle(rs.getString(2));
			b.setPrice(rs.getDouble(3));
			b.setCategory(rs.getString(4));
			b.setStock(rs.getDouble(5));
			booklistsearch.add(b);

			}
			return booklistsearch;

		}
		catch (SQLException e) 
		{ e.printStackTrace();
		return booklistsearch; } }

	public List<Customer> getAllCustomers() 
	{ 
		String template ="select * from customer"; 
		List<Customer> customerList = new ArrayList<>();
		try(PreparedStatement stmt = connection.prepareStatement(template)) {

			ResultSet rs =stmt.executeQuery(); 
			while(rs.next()) 
			{ 
				Customer c= new Customer();
				//System.out.println(rs.getLong(1)+" "+rs.getString(2)+" "+rs.getNString(3));
				c.setCid(rs.getLong(1));
				c.setName(rs.getString(2));
				customerList.add(c);

			} return customerList;
		} 
		catch(SQLException e) {
			e.printStackTrace(); 
			return customerList; } 
	}

	static int count =0;
	public int buyBook(long isbn, long cid) {

		Book book=new Book(); 
		Customer customer =new Customer();

		for(Book b : getAllBooks()) {

			if(b.getIsbn()==isbn) {
				book =b;
				break;}
		}
		for(Customer c : getAllCustomers()) {
			if(c.getCid()==cid)
			{
				customer =c;
				break;
			}
		}
		String template ="insert into purchase values(?,?,?)";
		try(PreparedStatement pstmt = connection.prepareStatement(template)) {
			pstmt.setLong(1, ++count); //autoincrement
			pstmt.setLong(2, isbn);
			pstmt.setLong(3, cid);

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}


}


/*
 * public Employee getEmployee(long empId) { String
 * template="select * from employee where empid=?"; try(PreparedStatement pstmt
 * = connection.prepareStatement(template)) { pstmt.setLong(1,empId); ResultSet
 * rs =pstmt.executeQuery(template); if(!rs.next()) {return null;} else {
 * Employee emp =new Employee();
 * //System.out.println(rs.getLong(1)+" "+rs.getString(2)+" "+rs.getNString(3));
 * emp.setEmpCode(rs.getLong(1)); emp.setName(rs.getString(2));
 * emp.setDept(rs.getString(3)); return emp; }
 * 
 * } catch (SQLException e) { e.printStackTrace(); return null; }
 * 
 * }
 * 
 * }
 */

