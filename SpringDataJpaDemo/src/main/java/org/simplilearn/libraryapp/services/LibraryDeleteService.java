package org.simplilearn.libraryapp.services;

import java.util.List;

import org.simplilearn.libraryapp.entities.Library;

public interface LibraryDeleteService {
	String deleteSingleLibrary(Library library);
	String pruneTable();
	String deleteAllTheseLibraries(List<Library> libraries);
	String deleteAllInBatch();
	String deleteAllTheseRecordsInBatch(List<Library> libraries);
	
}
