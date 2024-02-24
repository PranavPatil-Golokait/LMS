package com.sas.SalesAnalysisSystem.service;

import com.sas.SalesAnalysisSystem.exception.ResourceNotFoundException;
import com.sas.SalesAnalysisSystem.model.Profile;
import com.sas.SalesAnalysisSystem.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
    	
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(Long id, Profile profile) {
        Optional<Profile> profileDb = profileRepository.findById(id);
        if (profileDb.isPresent()) {
            Profile profileUpdate = profileDb.get();
            profileUpdate.setFirstName(profile.getFirstName());
            profileUpdate.setLastName(profile.getLastName());
            profileUpdate.setUsername(profile.getUsername());
            profileUpdate.setEmail(profile.getEmail());
            profileUpdate.setPhoneNumber(profile.getPhoneNumber());
            profileUpdate.setAddress(profile.getAddress());
            profileUpdate.setPersonalInformation(profile.getPersonalInformation());
            return profileRepository.save(profileUpdate);
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + id);
        }
    }

    @Override
    public List<Profile> getAllProfiles() {
        List<Profile> profiles = profileRepository.findAll();
        if (profiles.isEmpty()) {
            throw new ResourceNotFoundException("No profiles found");
        }
        return profiles;
    }

    @Override
    public Profile getProfileById(Long profileId) {
        Optional<Profile> profileDb = profileRepository.findById(profileId);
        if (profileDb.isEmpty()) {
            throw new ResourceNotFoundException("Record not found with id: " + profileId);
        }
        return profileDb.get();
    }

    @Override
    public void deleteProfile(Long id) {
        Optional<Profile> profileDb = profileRepository.findById(id);
        if (profileDb.isPresent()) {
            profileRepository.delete(profileDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + id);
        }
    }
}
