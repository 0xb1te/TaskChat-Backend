package com.six.taskchat;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.six.taskchat.entity.Message;
import com.six.taskchat.service.MessageService;

@WebMvcTest(MessageController.class)
class MessageController {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private MessageService messageService;

	@InjectMocks
	private MessageController messageController;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();
	}

	@Test
	void testGetMessagesByCategory() throws Exception {
		Long categoryId = 1L;
		List<Message> messages = Arrays.asList(new Message(1L, "Test message 1", categoryId),
				new Message(2L, "Test message 2", categoryId));

		when(messageService.getMessagesByCategory(categoryId)).thenReturn(messages);

		mockMvc.perform(get("/api/messages/category/{categoryId}", categoryId)).andExpect(status().isOk())
				.andExpect(content().json(
						"[{'id':1,'content':'Test message 1','categoryId':1},{'id':2,'content':'Test message 2','categoryId':1}]"));
	}

	@Test
	void testCreateMessage() throws Exception {
		Message message = new Message(1L, "New message", 1L);

		when(messageService.createMessage(message)).thenReturn(message);

		mockMvc.perform(post("/api/messages").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(message))).andExpect(status().isOk())
				.andExpect(content().json("{'id':1,'content':'New message','categoryId':1}"));
	}
}
