package test;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Path("home")
public class hello {
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		return "Hello, world!";
	}

	@GET
	@Produces({MediaType.TEXT_HTML})
	public InputStream viewHome() throws FileNotFoundException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("index.html").getFile());
		return new FileInputStream(file);
	}

	@GET
	@Path("param")
	@Produces(MediaType.TEXT_PLAIN)
	public String paramMethod(@QueryParam("name") String name) {
		return "Hello, " + name;
	}
	
	@POST
	@Path("post")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String postMethod(@FormParam("name") String name) {
	  return "<h2>Hello, " + name + "</h2>";
	}

}
