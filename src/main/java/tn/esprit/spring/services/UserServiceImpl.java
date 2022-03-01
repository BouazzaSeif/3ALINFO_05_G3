package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public List<User> retrieveAllUsers() {
		List<User> users = null;
		try {

			l.info("In Method retrieveAllUsers :");
			users = (List<User>) userRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (User user : users) {
				l.debug("user :" + user.getLastName());
			}
			l.info("Out of Method retrieveAllUsers with Success" + users.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllUsers with Errors : " + e);
		}

		return users;
	}

	@Override
	public User addUser(User u) {

		User u_saved = null;

		try {
			// TODO Log à ajouter en début de la méthode
			l.info("begin of the addUser method  ");
			u_saved = userRepository.save(u);
			// TODO Log à ajouter à la fin de la méthode
			l.debug(u.getLastName() + " added successfully");

		} catch (Exception e) {
			// TODO log ici : l....("error in addUser() : " + e);
			l.error("Error in method addUser with Errors : " + e);
		}

		return u_saved;
	}

	@Override
	public User updateUser(User u) {

		User userUpdated = null;

		try {
			l.debug("In Method updateUser() :");
			userUpdated = userRepository.save(u);
			l.debug("Out of Method updateUser() with Success");

		} catch (Exception e) {
			l.error("Out of Method updateUser() with Errors : " + e);
		}

		return userUpdated;
	}

	@Override
	public void deleteUser(String id) {

		try {
			l.debug("In Method deleteUser() :");
			userRepository.deleteById(Long.parseLong(id));
			l.debug("Out of Method deleteUser() with Success");

		} catch (Exception e) {
			l.error("error in deleteUser() : " + e);
		}

	}

	@Override
	public User retrieveUser(String id) {
		User u = null;
		try {
			l.debug("In Method retrieveUser() :");
             
			u = userRepository.findById(Long.parseLong(id)).isPresent()
					? userRepository.findById(Long.parseLong(id)).get()
					: null;
			l.debug("Out of Method retrieveUser() with Success");

		} catch (Exception e) {
			l.error("error in retrieveUser() : " + e);
		}

		return u;
	}
}