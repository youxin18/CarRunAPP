package com.example.cardrunfast;

public class Sentence {
    private String sentence;
    private String chinese;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public Sentence(String sentence, String chinese) {
        this.sentence = sentence;
        this.chinese = chinese;
    }
}
