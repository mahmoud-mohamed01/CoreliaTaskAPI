package com.example.CoreliaTask.service.Impl;

import com.example.CoreliaTask.dto.RespnseMessage;
import com.example.CoreliaTask.exception.NotFoundException;
import com.example.CoreliaTask.model.Contact;
import com.example.CoreliaTask.model.User;
import com.example.CoreliaTask.repository.ContactRepository;
import com.example.CoreliaTask.repository.UserRepository;
import com.example.CoreliaTask.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    UserRepository userRepository;
    ContactRepository contactRepository;
    UserDetailsServiceImpl userDetailsService;
    AuthServiceImpl authService;

    @Override
    public Contact addContact(Contact contact) {

        User user= authService.getCurrentUser();
        contact.setUser(user);
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Contact> pageContacts = contactRepository.findAll(pageDetails);
        List<Contact> contacts = pageContacts.getContent();
        return contacts;
    }

    @Override
    public Contact getContactById(Integer ContactId) {
        return  contactRepository.findById(ContactId)
                .orElseThrow(()-> new NotFoundException("Contact not found with this Id: " + ContactId));
    }

    @Override
    public List<Contact> searchByAccount(Integer accountId){
        User user = userRepository.findById(accountId)
                .orElseThrow(()-> new NotFoundException("User not found with this Id: " + accountId));
        List<Contact>contacts=contactRepository.findByUser(user);
        return contacts;
    }

    @Override
    public RespnseMessage updateContact(Integer contactId, Contact request) {

       Contact contact = contactRepository.findById(contactId)
                .orElseThrow(()-> new NotFoundException("Contact not found with this Id: " + contactId));

        // check the fields that need to be updated
        contact.setEmail(request.getEmail()!=null? request.getEmail():contact.getEmail());
        contact.setFirstName(request.getFirstName()!=null? request.getFirstName():contact.getFirstName());
        contact.setLastName(request.getLastName()!=null? request.getLastName():contact.getLastName());
        contact.setPhoneNumber(request.getPhoneNumber()!=null? request.getPhoneNumber():contact.getPhoneNumber());
        contact.setBirthdate(request.getBirthdate()!=null? request.getBirthdate():contact.getBirthdate());

        //update contact
        contactRepository.save(contact);
        return new RespnseMessage("Contact updated successfully");
    }

    @Override
    public RespnseMessage deleteContact(Integer ContactId) {

        //validate that current user match the user in contact
        User user= authService.getCurrentUser();
        Contact contact = contactRepository.findById(ContactId)
                .orElseThrow(()-> new NotFoundException("Contact not found with this Id: " + ContactId));
        if (user.getId()==contact.getUser().getId()){
            contactRepository.delete(contact);
        }
        return new RespnseMessage("Contact deleted successfully");
    }
}
