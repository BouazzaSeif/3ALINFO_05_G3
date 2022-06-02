package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

@SpringBootTest
public class UserServiceImplTest {

	@Autowired
	IUserService us;

	@Test
	@Order(1)
	public void testRetrieveAllUsers() {
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(1, listUsers.size());
	}

	@Test
	@Order(2)
	public void testAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		User u = new User("Seif", "Bouazza", d, Role.ADMINISTRATEUR);
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userAdded.getLastName());

	}

	@Test
	@Order(3)
	public void testModifyUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		User u = new User(1L, "Bouazza", "Seif", d, Role.INGENIEUR);
		User userUpdated = us.updateUser(u);
		Assertions.assertEquals(u.getLastName(), userUpdated.getLastName());
	}

	@Test
	@Order(5)
	public void testDeleteUser() {
		us.deleteUser("1");
		Assertions.assertNull(us.retrieveUser("1"));
		Assertions.assertEquals(0, us.retrieveAllUsers().size());
	}
}
