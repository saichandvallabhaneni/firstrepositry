package com.training;

import java.util.List;

import com.training.Book;
import com.training.BookDao;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path ("book")
public class AdminResource {
	
	private BookService bookService = new BookService();
	@GET // return a string
	public String Hello() {
		return "Hello! welcome to REST API";
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("addbook")
	//public int addBook(@FormParam("isbn") long isbn,@FormParam("title") String title,@FormParam("price") double price,@FormParam("category") String category,@FormParam("stock") double stock)
	public Book addBook(Book book)
	{
		/*
		 * BookDao bookDao = new BookDao(); int records =
		 * bookDao.addBook(isbn,title,price,category,stock); return records;
		 */
		return bookService.addBook(book);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/getbook")
		public List<Book> getbook()
		{
			//BookDao bookDao =new BookDao();
			return bookService.getAllBooks();
		}
	
	@DELETE
	@Path("deletebook/isbn/{isbn}")
	public int deleteBook(@PathParam("isbn") int isbn)
	{
		//BookDao bookDao =new BookDao();
		return bookService.deleteBook(isbn);
		}
	
	

	}

