package com.biz.book.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookVO {
	// NaverBook.txt. 파일 참조
	private String title;
	private String link;
	private String image;
	private String author;
	private String price;
	private String discount;
	private String publisher;
	private String isbn;
	private String description;
	private String pubdate;
	private String buydate;
	private int buyprice;
	private String buystore;

}
