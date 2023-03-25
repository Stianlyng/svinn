package ntnu.idatt2105.stianlyng.svinn.services;

import ntnu.idatt2105.stianlyng.svinn.entities.Message;
import ntnu.idatt2105.stianlyng.svinn.repositories.MessageRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public void deleteMessage(Integer messageId) {
        messageRepository.deleteById(messageId);
    }

    public Message updateMessage(Integer messageId, Message updatedMessage) {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new RuntimeException("Message not found"));
        message.setSender(updatedMessage.getSender());
        message.setReceiver(updatedMessage.getReceiver());
        message.setItem(updatedMessage.getItem());
        message.setContent(updatedMessage.getContent());
        message.setCreatedAt(updatedMessage.getCreatedAt());
    
        return messageRepository.save(message);
    }

}