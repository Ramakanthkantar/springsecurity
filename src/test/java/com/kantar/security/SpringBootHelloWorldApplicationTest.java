package com.kantar.security;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kantar.security.model.UserDTO;
import com.kantar.security.model.UserResponse;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootHelloWorldApplicationTest {
	
	//@MockBean
	//UserDao usrDao;
	
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	
	 @Test
	    public void contextLoads() {
		 
		 	    }
	 
	 ObjectMapper om = new ObjectMapper();

		@Before
		public void setUp() {
			mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		}
	 
	 @Test
		public void registerUserTest() throws Exception {
			UserDTO userDto = new UserDTO();
			userDto.setUsername("rama");
			userDto.setPassword("rama");
			String jsonRequest = om.writeValueAsString(userDto);
			MvcResult result = mockMvc.perform(post("/register").content(jsonRequest)
					.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
			String resultContent = result.getResponse().getContentAsString();
			
			UserResponse response=om.readValue(resultContent, UserResponse.class);
			
			Assert.assertTrue(response.isStatus() == Boolean.TRUE);
			
			//System.out.println("response********"+response);
		
			
			

		}

}
