package org.simplilearn.libraryapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.simplilearn.libraryapp.entities.Library;
import org.simplilearn.libraryapp.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class LibraryCreateServiceImpl implements LibraryCreateService{
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	public String addSingleLibrary(Library library) {
		libraryRepository.save(library);
		libraryRepository.flush();
		return "Library Record Saved";
	}

	@Override
	public String addAllLibraries(List<Library> libraries) {
		libraryRepository.saveAll(libraries);
		libraryRepository.flush();
		return "All libraries Saved";
	}

	@Override
	public Library addLibraryWithSaveAndFlush(Library library) {
		Library library2=libraryRepository.saveAndFlush(library);
		return library2;
	}

}
