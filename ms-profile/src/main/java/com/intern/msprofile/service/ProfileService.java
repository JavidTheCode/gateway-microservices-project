package com.intern.msprofile.service;

import com.intern.msprofile.dto.ProfileRequest;
import com.intern.msprofile.dto.ProfileResponse;
import com.intern.msprofile.entity.Profile;
import com.intern.msprofile.mapper.ProfileMapper;
import com.intern.msprofile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public ProfileResponse addProfile(ProfileRequest request) {
        Profile profile  = profileMapper.toEntity(request);
        Profile savedProfile = profileRepository.save(profile);
        return profileMapper.toResponse(savedProfile);
    }

    public List<ProfileResponse> getAllProfiles() {
        return profileRepository.findAll()
                .stream()
                .map(profileMapper::toResponse)
                .toList();
    }

    public ProfileResponse getProfileById(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Profile not found"));

        return profileMapper.toResponse(profile);
    }

   public void deleteProfile(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Profile not found"));

        profileRepository.delete(profile);
   }


}
