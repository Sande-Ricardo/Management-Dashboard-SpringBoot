package com.managementDashboard.RestAPI.controller.dto;

import com.managementDashboard.RestAPI.model.FlashCard;
import com.managementDashboard.RestAPI.model.Headline;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UserUpdateRequest(@NotBlank String name,
                                @NotBlank String last_name,
                                @NotBlank String username,
                                @NotBlank String email,
//                                @NotBlank String password,
                                @NotBlank List<Headline> headlines,
                                @NotBlank List<FlashCard> flashCards
                                ) {
}
