package com.kumar.rest;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(LibraryEventsRestService.class)
@AutoConfigureMockMvc
public class LibraryEventsRestServiceUnitTest {
	/*
	@Autowired
	MockMvc mvc; 
	
	@MockBean
	LibraryEventsProducer libraryEventsProducer;
	
	ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void postLibraryEvent_withBody() throws Exception {
		
		Book book = Book.builder().bookId(505).
				bookName("Spring Kafka").bookAuthor("Kumar Nagaraju").build();
		
		LibraryEvent libraryEvent = LibraryEvent.builder().libraryEventId(null).
				book(book).libraryEventType(LibraryEventType.NEW).build();
		
		String libraryEventStr = objectMapper.writeValueAsString(libraryEvent);
		Mockito.when(libraryEventsProducer.sendLibraryEvent_Approach2(libraryEvent)).thenReturn(null);
		
		mvc.perform(MockMvcRequestBuilders.post("/v1/libraryevent").contentType(MediaType.APPLICATION_JSON).
				content(libraryEventStr)).andExpect(status().isCreated());
		
	}
	
	@Test
	void postLibraryEvent_withoutBody() throws Exception {
		
		Book book = Book.builder().bookId(505).
				bookName("Spring Kafka").bookAuthor("Kumar Nagaraju").build();
		
		LibraryEvent libraryEvent = LibraryEvent.builder().libraryEventId(null).
				book(null).libraryEventType(LibraryEventType.NEW).build();
		
		String libraryEventStr = objectMapper.writeValueAsString(libraryEvent);
		Mockito.when(libraryEventsProducer.sendLibraryEvent_Approach2(libraryEvent)).thenReturn(null);
		String exceptedError = "book - must not be null";
		mvc.perform(MockMvcRequestBuilders.post("/v1/libraryevent").contentType(MediaType.APPLICATION_JSON).
				content(libraryEventStr)).andExpect(status().isBadRequest()).
		andExpect(content().string(exceptedError));
		
	}
	
	@Test
	void postLibraryEvent_withEmptyBody() throws Exception {
		
		Book book = Book.builder().bookId(505).
				bookName("Spring Kafka").bookAuthor("Kumar Nagaraju").build();
		
		LibraryEvent libraryEvent = LibraryEvent.builder().libraryEventId(null).
				book(new Book()).libraryEventType(LibraryEventType.NEW).build();
		
		String libraryEventStr = objectMapper.writeValueAsString(libraryEvent);
		Mockito.when(libraryEventsProducer.sendLibraryEvent_Approach2(libraryEvent)).thenReturn(null);
		String exceptedError ="book.bookAuthor - must not be blank,book.bookId - must not be null,book.bookName - must not be blank";
		mvc.perform(MockMvcRequestBuilders.post("/v1/libraryevent").contentType(MediaType.APPLICATION_JSON).
				content(libraryEventStr)).andExpect(status().isBadRequest()).
		andExpect(content().string(exceptedError));
		
	}
	
	@Test
	void updateLibraryEvent_withLibraryEventID() throws Exception {
		
		Book book = Book.builder().bookId(505).
				bookName("Spring Kafka").bookAuthor("Kumar Nagaraju").build();
		
		LibraryEvent libraryEvent = LibraryEvent.builder().libraryEventId(123).
				book(book).libraryEventType(LibraryEventType.UPDATE).build();
		
		String libraryEventStr = objectMapper.writeValueAsString(libraryEvent);
		Mockito.when(libraryEventsProducer.sendLibraryEvent_Approach2(libraryEvent)).thenReturn(null);
		
		mvc.perform(MockMvcRequestBuilders.put("/v1/libraryevent").contentType(MediaType.APPLICATION_JSON).
				content(libraryEventStr)).andExpect(status().isOk());
		
	}
	
	@Test
	void updateLibraryEvent_withoutLibraryEventID() throws Exception {
		
		Book book = Book.builder().bookId(505).
				bookName("Spring Kafka").bookAuthor("Kumar Nagaraju").build();
		
		LibraryEvent libraryEvent = LibraryEvent.builder().libraryEventId(null).
				book(book).libraryEventType(LibraryEventType.UPDATE).build();
		
		String libraryEventStr = objectMapper.writeValueAsString(libraryEvent);
		Mockito.when(libraryEventsProducer.sendLibraryEvent_Approach2(libraryEvent)).thenReturn(null);
		
		mvc.perform(MockMvcRequestBuilders.put("/v1/libraryevent").contentType(MediaType.APPLICATION_JSON).
				content(libraryEventStr)).andExpect(status().isBadRequest());
		
	}*/
}
