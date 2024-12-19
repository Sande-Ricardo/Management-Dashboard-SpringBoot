package com.managementDashboard.RestAPI.controller.dto;

import com.managementDashboard.RestAPI.model.FlashCard;
import com.managementDashboard.RestAPI.model.Headline;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record AuthCreateUserRequest(@NotBlank String username,
                                    @NotBlank String password,
                                    @NotBlank String email,
                                    AuthCreateRoleRequest roleRequest,

                                    String name,
                                    String last_name,
                                    List<Headline> headlines,
                                    List<FlashCard> flashCards

                                    ) {
}
