package com.example.orthoj.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class AnamData implements Serializable {
    private final SimpleStringProperty question;
    private final SimpleStringProperty response;
    private final SimpleStringProperty category;

    public AnamData(String question, String response, String category) {
        this.question = new SimpleStringProperty(question);
        this.response = new SimpleStringProperty(response);
        this.category = new SimpleStringProperty(category);
    }

    public String getQuestion() {
        return question.get();
    }

    public void setQuestion(String question) {
        this.question.set(question);
    }

    public StringProperty questionProperty() {
        return question;
    }

    public String getResponse() {
        return response.get();
    }

    public void setResponse(String response) {
        this.response.set(response);
    }

    public StringProperty responseProperty() {
        return response;
    }

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public StringProperty categoryProperty() {
        return category;
    }
}
