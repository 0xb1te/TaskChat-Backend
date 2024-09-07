package com.six.taskchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.six.taskchat.entity.Message;
import com.six.taskchat.service.MessageService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping("/category/{categoryId}")
	public List<Message> getMessagesByCategory(@PathVariable Long categoryId) {
		return messageService.getMessagesByCategory(categoryId);
	}

	@PostMapping
	public Message createMessage(@RequestBody Message message) {
		return messageService.createMessage(message);
	}
}
