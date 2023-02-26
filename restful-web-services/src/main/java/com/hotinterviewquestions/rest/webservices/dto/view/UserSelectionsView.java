package com.hotinterviewquestions.rest.webservices.dto.view;

import java.util.Set;

public class UserSelectionsView {

    private Set<String> difficulties;
    private Set<String> categories;

    public UserSelectionsView(Set<String> difficulties, Set<String> categories) {
        this.difficulties = difficulties;
        this.categories = categories;
    }

    public Set<String> getDifficulties() {
        return difficulties;
    }

    public void setDifficulties(Set<String> difficulties) {
        this.difficulties = difficulties;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }
}
