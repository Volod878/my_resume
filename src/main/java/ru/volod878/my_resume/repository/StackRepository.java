package ru.volod878.my_resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StackRepository extends JpaRepository<MyStack, Long> {

    List<MyStack> findByUserIdAndLevel(Long id, String level);
    List<MyStack> findByUserId(Long id);
}
