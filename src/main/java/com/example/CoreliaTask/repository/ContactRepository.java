package com.example.CoreliaTask.repository;

import com.example.CoreliaTask.model.Contact;
import com.example.CoreliaTask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {
    List <Contact> findByUser(User user);

}
