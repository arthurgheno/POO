package com.gheno;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private static Biblioteca bib = null;

    private List<Livro> livros;

    public Biblioteca() {
        livros = new ArrayList<>(20);
        livros.add(new Livro(1, "Alice's Adventures in Wonderland", "Lewis Carroll", 1865));
        livros.add(new Livro(2, "A Christmas Carol", "Charles Dickens", 1843));
        livros.add(new Livro(3, "The Picture of Dorian Gray", "Oscar Wilde", 1890));
        livros.add(new Livro(4, "The Scarlet Letter", "Nathaniel Hawthorne", 1850));
        livros.add(new Livro(5, "Robinson Crusoe", "Daniel Defoe", 1719));
        livros.add(new Livro(6, "Pride and Prejudice", "Jane Austen", 1813));
        livros.add(new Livro(7, "Moby-Dick", "Herman Melville", 1851));
        livros.add(new Livro(8, "Frankenstein", "Mary Shelley", 1818));
        livros.add(new Livro(9, "The Great Gatsby", "F. Scott Fitzgerald", 1925));
        livros.add(new Livro(10, "Nineteen Eighty-Four", "George Orwell", 1949));
        livros.add(new Livro(11, "To Kill a Mockingbird", "Harper Lee", 1960));
        livros.add(new Livro(12, "The Adventures of Sherlock Holmes", "Arthur Conan Doyle", 1892));
        livros.add(new Livro(13, "War and Peace", "Leo Tolstoy", 1869));
        livros.add(new Livro(14, "Jane Eyre", "Charlotte Bronte", 1847));
        livros.add(new Livro(15, "Wuthering Heights", "Emily Bronte", 1847));
        livros.add(new Livro(16, "Don Quixote", "Miguel de Cervantes", 1605));
        livros.add(new Livro(17, "The Hobbit", "J. R. R. Tolkien", 1937));
        livros.add(new Livro(18, "The Little Prince", "Antoine de Saint-Exupery", 1943));
        livros.add(new Livro(19, "The Metamorphosis", "Franz Kafka", 1915));
        livros.add(new Livro(20, "The Odyssey", "Homer", -700));
    }

    public List<Livro> livros() {
        return List.copyOf(livros);
    }

    public static Biblioteca getInstance() {
        if (bib == null) {
            bib = new Biblioteca();
        }
        return bib;
    }

    public void atualizaLivro(Livro livro) {
        livros.replaceAll(l -> l.codigo() == livro.codigo() ? livro : l);
    }
}

