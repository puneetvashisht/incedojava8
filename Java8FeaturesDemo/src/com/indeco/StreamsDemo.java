package com.indeco;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
	static class Book implements Comparable<Book>{		
		private long isbn;
		private String title;	
		private double rating;
		private double price;
		private String source;
		
		public Book(long isbn, String title, double rating, double price, String source) {
			this.isbn = isbn;
			this.title = title;
			this.rating = rating;
			this.price = price;
			this.source = source;
		}
		
		public void setTitle(String title) {
			this.title = title;
		}

		public long getIsbn() {
			return isbn;
		}
		
		public String getTitle() {
			return title;
		}
		
		public double getRating() {
			return rating;
		}
		
		public double getPrice() {
			return price;
		}
		
		public String getSource() {
			return source;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (isbn ^ (isbn >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			if (isbn != other.isbn)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Book [isbn=" + isbn + ", title=" + title + ", rating=" + rating + ", price=" + price + ", source="
					+ source + "]";
		}

		@Override
		public int compareTo(Book o) {
			return this.title.compareTo(o.title);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		List<Book> books = new ArrayList<>();
		books.addAll(DataExtractor.getFromAmazon("java"));
		books.addAll(DataExtractor.getFromBarnesAndNoble("java"));
		
		
		// Imperative 
		System.out.println(books);
		int count = 0;
		for(Book b : books){
			
			if(b.rating > 4.8){
				System.out.println(b);
				count++;
			}
			
		}
		System.out.println(count);
		
		
		// a. set-up a source - sql table
		// b. 0 or more intermediate operations - where clause 
		// c. terminal operation (column select)
		
		// SELECT count(b) from books_table b where b.rating>4.8
		
		// SELECT * from books_table
		
		
		//Declarative
//		books.stream()
//		.map(b -> {
//			b.setTitle("T");
//			return b;
//		})		
//		.filter(b -> b.rating>4.8)
//		.forEach(System.out::println);
		
		System.out.println(" *********** ");
		List<String> foundBooks = books.stream()
		.filter(b -> b.rating>4.8)
		.distinct()
		.limit(2)
		.map(b -> b.getTitle())
		.collect(Collectors.toList());
		
		System.out.println(foundBooks);
		
		boolean anyMatch = books.stream()
			.anyMatch((d) -> d.rating>5.8 && d.price < 50);
		
		System.out.println(anyMatch);
		
		
		boolean allMatch = books.stream()
				.allMatch((d) -> d.rating>4.8);
			
			System.out.println(allMatch);
			
			
			boolean noneMatch = books.stream()
					.noneMatch((d) -> d.rating < 1);
				
				System.out.println(noneMatch);
				
				
		// Numeric Streams
				System.out.println(IntStream.of(14, 2, 32).max());
				;
				
		// Inifinte Stream
				Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);
				
				infiniteStream.limit(4).forEach(System.out::println);
				
				
		
		
	}
	
	
	

}
