package com.sas.SalesAnalysisSystem.service;

import com.sas.SalesAnalysisSystem.model.Profile;

import java.util.List;

public interface ProfileService {
    Profile createProfile(Profile profile);

    Profile updateProfile(Long id, Profile profile);

    List<Profile> getAllProfiles();

    Profile getProfileById(Long profileId);

    void deleteProfile(Long profileId);
}
