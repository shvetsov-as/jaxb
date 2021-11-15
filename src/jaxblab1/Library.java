/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxblab1;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement (name="library")
@XmlType(propOrder={"name", "books"})//v kakom poridke generirovatb
public class Library {
    
    private String name;
    private ArrayList<Book> books = new ArrayList<>();

    @XmlElement(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @XmlElementWrapper(name="books")//wrapper - soderjit drygie docymentbI
    @XmlElement(name="book")
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{" + "name=" + name + ", books=" + books + '}';
    }
    
    
    
}
