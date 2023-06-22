package com.schoolmanagement.repository;


import com.schoolmanagement.entity.ContactMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage,Long> {

    Page<ContactMessage> findAllByEmail(String email, Pageable pageable);
}
