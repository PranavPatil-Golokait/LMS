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
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllProfiles() {
        try {
            List<Profile> profiles = profileService.getAllProfiles();
            return ResponseEntity.ok().body(profiles);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No profiles found");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProfileById(@PathVariable("id") Long id) {
        try {
            Profile profile = profileService.getProfileById(id);
            return ResponseEntity.ok().body(profile);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/add-profile")
    public ResponseEntity<Object> createProfile(@Valid @RequestBody Profile profile) {
        try {
            Profile createdProfile = profileService.createProfile(profile);
            return ResponseEntity.ok().body(createdProfile);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/update-profile")
    public ResponseEntity<Object> updateProfile(@PathVariable("id") Long id, @Valid @RequestBody Profile profile) {
        try {
            Profile updatedProfile = profileService.updateProfile(id, profile);
            return ResponseEntity.ok().body(updatedProfile);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("delete-profile/{id}")
    public HttpStatus deleteProfile(@PathVariable("id") Long id) {
        this.profileService.deleteProfile(id);
        return HttpStatus.OK;
    }
}
