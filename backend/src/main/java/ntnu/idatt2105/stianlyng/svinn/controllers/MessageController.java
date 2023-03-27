package ntnu.idatt2105.stianlyng.svinn.controllers;

import ntnu.idatt2105.stianlyng.svinn.entities.Message;
import ntnu.idatt2105.stianlyng.svinn.services.MessageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing message-related requests.
 */
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

/**
     * Creates a new message using the provided Message instance.
     *
     * @param message the Message instance to be created
     * @return ResponseEntity containing the created Message instance
     */
    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message createdMessage = messageService.createMessage(message);
        return ResponseEntity.ok(createdMessage);
    }

    /**
     * Retrieves all messages.
     *
     * @return ResponseEntity containing a list of all Message instances
     */
    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        return ResponseEntity.ok(messages);
    }

    /**
     * Deletes a message with the specified ID.
     *
     * @param messageId the ID of the message to be deleted
     * @return ResponseEntity with an empty body and a No Content (204) status code
     */
    @DeleteMapping("/{messageId}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Integer messageId) {
        messageService.deleteMessage(messageId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Updates a message with the specified ID using the provided Message instance.
     *
     * @param messageId the ID of the message to be updated
     * @param updatedMessage the Message instance containing the updated information
     * @return ResponseEntity containing the updated Message instance
     */
    @PutMapping("/{messageId}")
    public ResponseEntity<Message> updateMessage(@PathVariable Integer messageId, @RequestBody Message updatedMessage) {
        Message message = messageService.updateMessage(messageId, updatedMessage);
        return ResponseEntity.ok(message);
    }
}