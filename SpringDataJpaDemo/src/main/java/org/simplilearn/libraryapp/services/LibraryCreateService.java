package org.simplilearn.libraryapp.services;

import java.util.List;

import org.simplilearn.libraryapp.entities.Library;

public interface LibraryCreateService {
	String addSingleLibrary(Library library);
	String addAllLibraries(List<Library> libraries);
	Library addLibraryWithSaveAndFlush(Library library);
}
