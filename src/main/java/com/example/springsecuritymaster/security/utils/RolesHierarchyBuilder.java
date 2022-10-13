package com.example.springsecuritymaster.security.utils;

public class RolesHierarchyBuilder {


    private StringBuilder stringBuilder = new StringBuilder();

    public RolesHierarchyBuilder append(String upLineRole, String downLineRole) {
        stringBuilder.append(
                String.format("ROLE_%s > ROLE_%s\n",
                        upLineRole, downLineRole)

        );
        return this;
    }


    public String build() {
        return stringBuilder.toString();
    }
}
