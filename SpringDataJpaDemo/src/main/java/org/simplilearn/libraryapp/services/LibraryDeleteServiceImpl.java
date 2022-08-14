package org.simplilearn.libraryapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.simplilearn.libraryapp.entities.Library;
import org.simplilearn.libraryapp.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibraryDeleteServiceImpl implements LibraryDeleteService{
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	public String deleteSingleLibrary(Library library) {
		libraryRepository.delete(library);
		return "Library Delete";
	}

	@Override
	public String pruneTable() {
		libraryRepository.deleteAll();
		return "Prune Completed";
	}

	@Override
	public String deleteAllTheseLibraries(List<Library> libraries) {
		libraryRepository.deleteAll(libraries);
		return "Delete All Complete";
	}

	@Override
	public String deleteAllInBatch() {
		libraryRepository.deleteAllInBatch();
		return "Delete All in Batch Completed";
	}

	@Override
	public String deleteAllTheseRecordsInBatch(List<Library> libraries) {
		libraryRepository.deleteAllInBatch(libraries);
		return "Delete all these libraries in Batch Mode";
	}

}
