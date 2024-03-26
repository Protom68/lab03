package org.example.lab03.model;
import java.util.List;

public class Book {
   private int id;
   private int Year;
   private String Title;
    private String handle;
    private String Publisher;
    private String ISBN;
    private String Pages;
    private List<String>Notes;
    private String created_at;
    private List <Zloczynca> villains;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPages() {
        return Pages;
    }

    public void setPages(String pages) {
        Pages = pages;
    }

    public List<String> getNotes() {
        return Notes;
    }

    public void setNotes(List<String> notes) {
        Notes = notes;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public List<Zloczynca> getVillains() {
        return villains;
    }

    public void setVillains(List<Zloczynca> villains) {
        this.villains = villains;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Year=" + Year +
                ", Title='" + Title + '\'' +
                ", handle='" + handle + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", Pages='" + Pages + '\'' +
                ", Notes=" + Notes +
                ", created_at='" + created_at + '\'' +
                ", villains=" + villains +
                '}';
    }
}