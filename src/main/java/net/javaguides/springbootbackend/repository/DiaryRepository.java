package net.javaguides.springbootbackend.repository;

import net.javaguides.springbootbackend.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long>{

}