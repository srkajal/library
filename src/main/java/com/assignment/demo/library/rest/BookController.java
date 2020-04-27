package com.assignment.demo.library.rest;

import com.assignment.demo.library.model.request.BookRequest;
import com.assignment.demo.library.model.response.BaseResponse;
import com.assignment.demo.library.model.response.BookListResponse;
import com.assignment.demo.library.model.response.BookResponse;
import com.assignment.demo.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping(value = "greeting")
    public BaseResponse greeting() {

        return new BaseResponse(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value(), "Message from Book controller!");
    }

    @GetMapping
    public BookListResponse getBookList() {
        return bookService.getBookList();
    }

    @GetMapping("{bookId}")
    public BookResponse getBookById(@PathVariable("bookId") long bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("library/{libraryId}")
    public BookListResponse getBookByLibraryId(@PathVariable("libraryId") long libraryId) {
        return bookService.getBooksByLibraryId(libraryId);
    }

    @DeleteMapping("{bookId}")
    public BaseResponse removeBookById(@PathVariable("bookId") long bookId) {
        return bookService.removeBookById(bookId);
    }

    @PutMapping
    public BaseResponse updateBookById(@RequestBody @Valid BookRequest bookRequest) {
        return bookService.updateBook(bookRequest);
    }

    @PostMapping
    public BaseResponse addBook(@RequestBody @Valid BookRequest bookRequest) {
        return bookService.addBook(bookRequest);
    }
}
