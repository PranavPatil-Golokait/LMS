package com.sas.SalesAnalysisSystem.controller;

import com.sas.SalesAnalysisSystem.exception.ResourceNotFoundException;
import com.sas.SalesAnalysisSystem.model.Profile;
import com.sas.SalesAnalysisSystem.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profiles")
    public ResponseEntity<Object> getAllProfiles() {
        try {
            List<Profile> profiles = profileService.getAllProfiles();
            return ResponseEntity.ok().body(profiles);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No profiles found");
        }
    }

    @GetMapping("/profiles/{id}")
    public ResponseEntity<Object> getProfileById(@PathVariable("id") Long id) {
        try {
            Profile profile = profileService.getProfileById(id);
            return ResponseEntity.ok().body(profile);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/profiles")
    public ResponseEntity<Object> createProfile(@Valid @RequestBody Profile profile) {
        try {
            Profile createdProfile = profileService.createProfile(profile);
            return ResponseEntity.ok().body(createdProfile);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/profiles/{id}")
    public ResponseEntity<Object> updateProfile(@PathVariable("id") Long id, @Valid @RequestBody Profile profile) {
        try {
            Profile updatedProfile = profileService.updateProfile(id, profile);
            return ResponseEntity.ok().body(updatedProfile);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/profiles/{id}")
    public HttpStatus deleteProfile(@PathVariable("id") Long id) {
        this.profileService.deleteProfile(id);
        return HttpStatus.OK;
    }
}
