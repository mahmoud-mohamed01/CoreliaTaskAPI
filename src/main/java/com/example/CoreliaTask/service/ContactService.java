package com.example.CoreliaTask.service;

import com.example.CoreliaTask.dto.RespnseMessage;
import com.example.CoreliaTask.model.Contact;

import java.util.List;

public interface ContactService {
    Contact addContact(Contact contact);

    List<Contact> getAllContacts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    Contact getContactById(Integer id);

    List<Contact> searchByAccount(Integer AccountId);

    RespnseMessage updateContact(Integer contactId, Contact contact);

    RespnseMessage deleteContact(Integer contactID);

}
