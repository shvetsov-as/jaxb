/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxblab1;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "book")
@XmlType(propOrder = {"isbn", "title", "author"})//v kakom poridke generirovatb
class Book {

    private String isbn;
    private String title;
    private String author;

    
    public String getIsbn() {
        return isbn;
    }
@XmlAttribute(name = "isbn")// vnutri tega < book isbn = "" >
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    
    public String getTitle() {
        return title;
    }
@XmlElement(name = "title") //new teg < title > ... < /title >
    public void setTitle(String title) {
        this.title = title;
    }

    
    public String getAuthor() {
        return author;
    }
@XmlElement(name = "author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title=" + title + ", author=" + author + '}';
    }

}
