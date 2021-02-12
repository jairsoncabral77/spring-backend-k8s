package squad.api;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

import squad.api.data.UserRepository;
import squad.api.model.User;
import squad.api.service.UserService;

@SpringBootTest
@EnableAutoConfiguration
@ContextConfiguration(locations = "classpath:db/datasource.xml", classes = {UserService.class, UserRepository.class})
@EnableTransactionManagement
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
   DirtiesContextTestExecutionListener.class,
   TransactionalTestExecutionListener.class,
   DbUnitTestExecutionListener.class })
class UserServiceTests {

	@Autowired(required = true)
	UserService service;
	User expectedUser = new User(1L,"User 1");

	@Test
	@DatabaseSetup(value = "classpath:db/empty.xml")
	@ExpectedDatabase(value = "classpath:db/user1.xml")
	public void addUser() {
		User user = new User();
		user.setName("User 1");
		service.addUser(user);
		Assert.assertEquals(expectedUser, user);
	}

	@Test
	@DatabaseSetup(value = "classpath:db/user1.xml")
	public void geUser() {
		User user =	service.getUser(1L);
		Assert.assertEquals(expectedUser, user);
	}
	
	@Test
	@DatabaseSetup(value = "classpath:db/user1.xml")
	public void geUsers() {
		List<User> users =	service.getUsers();
		Assert.assertEquals(1,users.size());
		Assert.assertTrue(users.contains(expectedUser));
	}
}
