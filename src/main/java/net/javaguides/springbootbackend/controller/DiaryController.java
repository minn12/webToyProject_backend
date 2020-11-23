package net.javaguides.springbootbackend.controller;

import net.javaguides.springbootbackend.exception.ResourceNotFoundException;
import net.javaguides.springbootbackend.model.Diary;
import net.javaguides.springbootbackend.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class DiaryController {

    @Autowired
    private DiaryRepository diaryRepository;

    // get all diary
    @GetMapping("/diaries")
    public List < Diary > getAllDiary() {
        return diaryRepository.findAll();
    }

    // create diary rest api
    @PostMapping("/diaries")
    public Diary createDiary(@RequestBody Diary diary) {
        return diaryRepository.save(diary);
    }

    // get diary by id rest api
    @GetMapping("/diaries/{id}")
    public ResponseEntity < Diary > getDiaryById(@PathVariable Long id) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diary not exist with id :" + id));
        return ResponseEntity.ok(diary);
    }

    // update diary rest api

    @PutMapping("/diaries/{id}")
    public ResponseEntity < Diary > updateDiary(@PathVariable Long id, @RequestBody Diary diaryDetails) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diary not exist with id :" + id));

        diary.setTitle(diaryDetails.getTitle());
        diary.setContent(diaryDetails.getContent());
        diary.setEmotion(diaryDetails.getEmotion());

        Diary updatedDiary = diaryRepository.save(diary);
        return ResponseEntity.ok(updatedDiary);
    }

    // delete diary rest api
    @DeleteMapping("/diaries/{id}")
    public ResponseEntity <Map< String, Boolean >> deleteDiary(@PathVariable Long id) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diary not exist with id :" + id));

        diaryRepository.delete(diary);
        Map< String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
