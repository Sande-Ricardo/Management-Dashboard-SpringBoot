package com.managementDashboard.RestAPI.controller.dto;

import jakarta.validation.constraints.NotBlank;


//reemplazar el username por email
public record AuthLoginRequest(@NotBlank String email,
                               @NotBlank String password) {
}
