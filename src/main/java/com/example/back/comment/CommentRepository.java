package com.example.back.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
