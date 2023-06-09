package org.lessons.java;

public class Book {

    private String title;
    private int pages;
    private String author;
    private String publisher;

    public Book(String title, int numPages, String author, String publisher) {
        setTitle(title);
        setPages(numPages);
        setAuthor(author);
        setPublisher(publisher);
    }


    private boolean isEmptyString(String str){
        return str == null || str.trim().isEmpty();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (isEmptyString(title)) {
            throw new IllegalArgumentException("Titolo non valido");
        }
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int numPages) {
        if (numPages <= 0) {
            throw new IllegalArgumentException("Numero pagine non valido");
        }
        this.pages = numPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (isEmptyString(author)) {
            throw new IllegalArgumentException("Autore non valido");
        }
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if (isEmptyString(publisher)) {
            throw new IllegalArgumentException("Editore non valido");
        }
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }

}
