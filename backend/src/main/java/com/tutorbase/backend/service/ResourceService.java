package com.tutorbase.backend.service;

import com.cloudinary.Cloudinary;
// REMOVED: import com.cloudinary.utils.ObjectUtils; (We don't need this anymore)
import com.tutorbase.backend.entity.Resource;
import com.tutorbase.backend.enums.GradeLevel;
import com.tutorbase.backend.enums.Subject;
import com.tutorbase.backend.enums.Term;
import com.tutorbase.backend.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private Cloudinary cloudinary;

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public List<Resource> getResourcesByFilter(GradeLevel grade, Subject subject, Term term) {
        return resourceRepository.findByGradeAndSubjectAndTerm(grade, subject, term);
    }

    public Resource uploadResource(String title, GradeLevel grade, Subject subject, Term term, MultipartFile file) throws IOException {

        // FIX 1: Use "Map.of()" (Standard Java) instead of ObjectUtils
        // This prevents the "Cannot find symbol" error
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), Map.of());

        String url = (String) uploadResult.get("url");

        Resource resource = new Resource();
        resource.setTitle(title);
        resource.setGrade(grade);
        resource.setSubject(subject);
        resource.setTerm(term);
        resource.setFileURL(url);

        return resourceRepository.save(resource);
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }
}