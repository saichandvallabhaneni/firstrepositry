package com.training;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("book")
public class CustomerResource {
	
	private BookService bookService = new BookService();
	@POST
	@Path("/buyupdate")
	public int updateBookStock(@QueryParam("isbn") long isbn)
	{
		//BookDao bookDao =new BookDao();
		return bookService.updateBookStock(isbn);
		}
	

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/booktitlesearch")
		public List<Book> bookTitleSearch(@QueryParam("title") String title)
		{
			//BookDao bookDao =new BookDao();
			return bookService.bookTitleSearch(title);
		}
	
	@POST
	@Path("/buybook")
	public int buyBook(@QueryParam("isbn") long isbn,@QueryParam("cid") long cid)
	{
		//BookDao bookDao =new BookDao();
		return bookService.buyBook(isbn,cid);
		}
}
