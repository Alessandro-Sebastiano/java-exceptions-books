package org.lessons.java;

import java.lang.invoke.StringConcatFactory;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class Main {

    public static void main(String[] arg){

        Scanner input = new Scanner(System.in);

        System.out.println("Quanti libri vuoi inserire?");

        int numOfBook = Integer.parseInt(input.nextLine());

        Book[] books = new Book[numOfBook];

        int i = 0;
        while (i < books.length){

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

        for (Book book: books) {
            System.out.println(book);
        }

    }

}
