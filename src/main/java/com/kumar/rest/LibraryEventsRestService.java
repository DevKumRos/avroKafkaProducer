package com.kumar.rest;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
;

@RestController
@Slf4j
public class LibraryEventsRestService {
	/*
	@Autowired
	LibraryEventsProducer libraryEventsProducer;
	

	@PostMapping("/v1/libraryevent")
	public ResponseEntity<LibraryEvent> addBookToLibrary(@Valid @RequestBody LibraryEvent libraryEvent) throws JsonProcessingException {
		
		log.info("Before Call Library Event");
		*//*invoke kafka producer. Asynchronoss call Approach 1
		 * 
		 libraryEventsProducer.sendLibraryEvent(libraryEvent);
		 
		 *//*
		
		*//* invoke kafka producer. Synchronoss call
		 * 
		SendResult<Integer, String> sendResult = libraryEventsProducer.sendLibraryEventSynchronoss(libraryEvent);
		log.info("sendResult details {}", sendResult.toString());
		
		*//*
		
		*//*invoke kafka producer. Asynchronoss call Approach 2
		 *//*
		 libraryEvent.setLibraryEventType(LibraryEventType.NEW);
		 libraryEventsProducer.sendLibraryEvent_Approach2(libraryEvent);
		 
		 
		log.info("After Call Library Event");
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
		
	}
	
	@PutMapping("/v1/libraryevent")
	public ResponseEntity<?> updateBookToLibrary(@Valid @RequestBody LibraryEvent libraryEvent) throws JsonProcessingException {
		
		if(libraryEvent.getLibraryEventId() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Library Event Id is not available");
		}
		libraryEvent.setLibraryEventType(LibraryEventType.UPDATE);
		libraryEventsProducer.sendLibraryEvent_Approach2(libraryEvent);
		
		return ResponseEntity.status(HttpStatus.OK).body(libraryEvent);
	}
*/
}
