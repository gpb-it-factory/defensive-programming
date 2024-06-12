package com.example.demo.npe.acl;

import org.jetbrains.annotations.NotNull;

public record User(@NotNull String name, @NotNull String email, int age) { }
