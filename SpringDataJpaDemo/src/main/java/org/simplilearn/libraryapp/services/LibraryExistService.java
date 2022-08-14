package org.simplilearn.libraryapp.services;

public interface LibraryExistService {
	boolean checkLibraryExistsById(int id);
	boolean checkLibraryExistsByExample(String commaSeperatedBookNames);
}
