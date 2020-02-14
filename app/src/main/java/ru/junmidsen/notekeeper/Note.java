package ru.junmidsen.notekeeper;

public class Note {
    private String title;
    private String description;
    private int colorId;

    public Note(String title, String description, int colorId) {
        this.title = title;
        this.description = description;
        this.colorId = colorId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getColorId() {
        return colorId;
    }
}
