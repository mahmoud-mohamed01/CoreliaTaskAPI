package com.example.CoreliaTask.controller;

import com.example.CoreliaTask.config.AppConstants;
import com.example.CoreliaTask.dto.RespnseMessage;
import com.example.CoreliaTask.model.Contact;
import com.example.CoreliaTask.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ContactController {
    ContactService contactService;

    @PostMapping("/accounts/contacts")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
        Contact savedContact = contactService.addContact(contact);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    @GetMapping("/accounts/contacts")
    public ResponseEntity<List<Contact>> getContacts( @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                                      @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
                                                      @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_CONTACTS_BY, required = false) String sortBy,
                                                      @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder){
        List<Contact> contacts = contactService.getAllContacts(pageNumber,pageSize,sortBy,sortOrder);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}/contacts")
    public ResponseEntity<List<Contact>> getContactByAccount( @PathVariable Integer id ){
        List<Contact> contacts= contactService.searchByAccount(id);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }


    @GetMapping("/accounts/contacts/{id}")
    public ResponseEntity<Contact> getContactById( @PathVariable Integer id ){
        Contact contact = contactService.getContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PutMapping("/accounts/contacts/{id}")
    public ResponseEntity<RespnseMessage> updateContactById( @PathVariable Integer id, @RequestBody Contact contact ){
        RespnseMessage message = contactService.updateContact(id,contact);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/accounts/contacts/{id}")
    public ResponseEntity<RespnseMessage> deleteContactById( @PathVariable Integer id ){
        RespnseMessage message = contactService.deleteContact(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
