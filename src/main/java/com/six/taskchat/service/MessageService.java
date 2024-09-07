package com.six.taskchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.six.taskchat.entity.Message;
import com.six.taskchat.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessagesByCategory(Long categoryId) {
        return messageRepository.findByCategory_Id(categoryId);
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }
}
