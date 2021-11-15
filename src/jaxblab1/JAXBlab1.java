/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxblab1;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author User
 */
public class JAXBlab1 {

    public static void main(String[] args) {
        System.out.println("Reading from xml file");
        try {
            JAXBContext context = JAXBContext.newInstance(Library.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            Library library = (Library) unmarshaller.unmarshal(new File("library1.xml"));//

            System.out.println("Library read from file " + library.getName());

            ArrayList<Book> books = library.getBooks();

            for (Book b : books) {
                System.out.println("Book: " + b.toString());
            }

        } catch (JAXBException ex) {
            System.out.println("OSHIBKA TUT  " + ex.getMessage());
        }

        System.out.println("Write in XML");

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("example1.xml")))) {// ispolzuem try s res dlia zapisi
            JAXBContext context = JAXBContext.newInstance(Library.class);

            Library library = new Library();

            library.setName("Epos");

            ArrayList<Book> books = new ArrayList<>();

            Book book = new Book();

            book.setIsbn("222222222222222");
            book.setTitle("Odyssey");
            book.setAuthor("Homer");

            books.add(book);

            book = new Book();
            book.setIsbn("333333333333333");
            book.setTitle("Mahabharata");
            book.setAuthor("Vyasa");

            books.add(book);

            library.setBooks(books);

            //generir file
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
//            for(Book b: books){
//                System.out.println(b.toString());
//            }

            //marshaller.marshal(library, System.out);//book - napisatb 1 knigy
            //marshaller.marshal(library, System.out);
            
            //marshaller.marshal(library, new FileWriter(new File("example.xml"))); zapis v fail. Nado ispolzovatb close(); - pomestim eto v try s resursom
            
            marshaller.marshal(library, dos);// posle ispolzovaniya try s resursom



        } catch (JAXBException ex) {
            Logger.getLogger(JAXBlab1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JAXBlab1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
