package com.tutorbase.backend.controller;

import com.tutorbase.backend.entity.Resource;
import com.tutorbase.backend.enums.GradeLevel;
import com.tutorbase.backend.enums.Subject;
import com.tutorbase.backend.enums.Term;
import com.tutorbase.backend.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/resources")
@CrossOrigin(origins = "*")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public List<Resource> getAll() {
        return resourceService.getAllResources();
    }

    // Filter API: GET /api/resources/filter?grade=GRADE_10&subject=MATHS&term=TERM_1
    @GetMapping("/filter")
    public List<Resource> filter(
            @RequestParam GradeLevel grade,
            @RequestParam Subject subject,
            @RequestParam Term term) {
        return resourceService.getResourcesByFilter(grade, subject, term);
    }

    // Upload API
    @PostMapping(consumes = {"multipart/form-data"})
    public Resource upload(
            @RequestParam("title") String title,
            @RequestParam("grade") GradeLevel grade,
            @RequestParam("subject") Subject subject,
            @RequestParam("term") Term term,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        return resourceService.uploadResource(title, grade, subject, term, file);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        resourceService.deleteResource(id);
    }
}