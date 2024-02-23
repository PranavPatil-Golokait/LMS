package com.sas.SalesAnalysisSystem.repository;

import com.sas.SalesAnalysisSystem.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
