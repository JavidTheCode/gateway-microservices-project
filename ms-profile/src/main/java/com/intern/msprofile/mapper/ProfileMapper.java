package com.intern.msprofile.mapper;

import com.intern.msprofile.dto.ProfileRequest;
import com.intern.msprofile.dto.ProfileResponse;
import com.intern.msprofile.entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {
    public Profile toEntity(ProfileRequest request){
        return Profile.builder()
                .name(request.getName())
                .email(request.getEmail())
                .bio(request.getBio())
                .build();
    }

    public ProfileResponse toResponse(Profile profile){
        return ProfileResponse.builder()
                .id(profile.getId())
                .name(profile.getName())
                .email(profile.getEmail())
                .bio(profile.getBio())
                .build();
    }
}
