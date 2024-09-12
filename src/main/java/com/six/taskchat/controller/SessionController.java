package com.six.taskchat.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.six.taskchat.entity.Session;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/session")
@CrossOrigin(origins = { "http://localhost:4200" })
public class SessionController {

	@GetMapping(value = "/id")
	public Session home(HttpSession session) {
		return new Session(UUID.randomUUID().toString().replace("-", ""));
	}
}