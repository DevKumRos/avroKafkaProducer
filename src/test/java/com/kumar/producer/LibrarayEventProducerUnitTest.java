package com.kumar.producer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LibrarayEventProducerUnitTest {
	/*
	@InjectMocks
	LibraryEventsProducer eventProducer;
	
	@Spy
	ObjectMapper objectMapper;
	
	
	@Mock
	KafkaTemplate<Integer, String> kafkaTemplate;

	@Test
	public void approach2_test_failure() throws JsonProcessingException {
		Book book = Book.builder().bookId(505).
				bookName("Spring Kafka").bookAuthor("Kumar Nagaraju").build();
		
		LibraryEvent libraryEvent = LibraryEvent.builder().libraryEventId(null).
				book(book).libraryEventType(LibraryEventType.NEW).build();
		SettableListenableFuture future = new SettableListenableFuture<>();
		future.setException(new RuntimeException("Calling Kafka"));
		Mockito.when(kafkaTemplate.send(Mockito.any(ProducerRecord.class))).thenReturn(future);
		assertThrows(Exception.class, ()->eventProducer.sendLibraryEvent_Approach2(libraryEvent).get());
	}
	
	@Test
	public void approach2_test_Success() throws JsonProcessingException, InterruptedException, ExecutionException {
		Book book = Book.builder().bookId(505).
				bookName("Spring Kafka").bookAuthor("Kumar Nagaraju").build();
		
		LibraryEvent libraryEvent = LibraryEvent.builder().libraryEventId(null).
				book(book).libraryEventType(LibraryEventType.NEW).build();
		ProducerRecord<Integer, String> producerRecord = new ProducerRecord<Integer, String>
		("library-events", libraryEvent.getLibraryEventId(), objectMapper.writeValueAsString(libraryEvent));
		RecordMetadata recordMetaData = new RecordMetadata(new TopicPartition("library-events", 1), 1, 1, 342, System.currentTimeMillis(), 1, 2);
		SendResult<Integer, String> sendResult = new SendResult<>(producerRecord, recordMetaData);
		SettableListenableFuture future = new SettableListenableFuture<>();
		future.set(sendResult);
		Mockito.when(kafkaTemplate.send(Mockito.any(ProducerRecord.class))).thenReturn(future);
		SendResult<Integer, String> response = eventProducer.sendLibraryEvent_Approach2(libraryEvent).get();
		assertEquals(1, response.getRecordMetadata().partition());
	}*/
}
