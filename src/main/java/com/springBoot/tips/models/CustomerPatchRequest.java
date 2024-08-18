package com.springBoot.tips.models;

public record CustomerPatchRequest(
        Long id,
        String name,
        String email
) {
}
