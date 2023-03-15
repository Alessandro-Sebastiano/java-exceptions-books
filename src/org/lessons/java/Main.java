package org.lessons.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] arg){

        Scanner input = new Scanner(System.in);

        System.out.println("Quanti libri vuoi inserire?");

        int numOfBook = Integer.parseInt(input.nextLine());

        Book[] books = new Book[numOfBook];

        int i = 0;
        while (i < books.length){
            int count = i + 1;
            System.out.println("Inserisci i dati del libro n " + count);

            String bookName = "";
            while (bookName.isEmpty()){
                System.out.println("Inserisci il nome del libro");
                bookName = input.nextLine();
                if (bookName.isEmpty()){
                    System.out.println("Inserire un nome valido");
                }
            }

            int numOfPages = 0;
            try {
                System.out.println("Inserisci il numero di pagine: ");
                 numOfPages = Integer.parseInt(input.nextLine());
            }catch (IllegalArgumentException e){
                System.out.println("Numero pagine non valido");
            }


            String author = "";
            while (author.isEmpty()) {
                System.out.println("Inserisci l'autore del libro: ");
                author = input.nextLine();
            }


            String publisher = "";
            while (publisher.isEmpty()) {
                System.out.println("Inserisci l'editore del libro: ");
                publisher = input.nextLine();
            }

            try {
                Book newBook = new Book(bookName, numOfPages, author, publisher);

                books[i] = newBook;

                ++i;
            }catch (IllegalArgumentException e){
                System.out.println("Errore: " + e);
            }
        }

        input.close();

        File file = new File("books.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(file.exists()){
            System.out.println("File creato correttamente");
            System.out.println(file.getPath());
        }else {
            System.out.println("Nessun file creato");
        }

        try {
            FileWriter writer = new FileWriter("books.txt");
            for (Book book: books) {
                writer.write(book.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
