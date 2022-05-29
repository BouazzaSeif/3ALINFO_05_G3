package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeControllerIntegrationTests {

	@Autowired
	private MockMvc mockMvc;
	private Employe employe = new Employe("Bouazza", "Seif", "seifeddine.bouazza@esprit.tn", true, Role.INGENIEUR);

	@DisplayName("integration test for ajouterEmploye method")
	@Test
	void testAjouterEmploye() throws JsonProcessingException, Exception {
		String empJson = new ObjectMapper().writeValueAsString(employe);
		MvcResult mvcResult = this.mockMvc
				.perform(post("/ajouterEmployer").contentType("application/json").content(empJson)).andDo(print())
				.andExpect(status().isOk()).andReturn();
		employe.setId(employe.getId() + 1);
		empJson = new ObjectMapper().writeValueAsString(employe);
		String actualResponseBody = mvcResult.getResponse().getContentAsString();
		assertThat(actualResponseBody).isEqualToIgnoringWhitespace(empJson);
	}

	@DisplayName("integration test for mettreAjourEmailByEmployeId method")
	@Test
	void testMettreAjourEmailByEmployeId() throws JsonProcessingException, Exception {
		String newEmail = "newemail@gmail.com";
		this.mockMvc.perform(put("/modifyEmail/{id}/{newemail}", "1", newEmail)).andDo(print())
				.andExpect(status().isOk());
		String allEmpsString = this.mockMvc.perform(get("/getAllEmployes")).andReturn().getResponse()
				.getContentAsString();
		List<Employe> empsList = new ObjectMapper().readValue(allEmpsString, new TypeReference<List<Employe>>() {
		});
		assertEquals(empsList.get(0).getEmail(), newEmail);
	}
}
