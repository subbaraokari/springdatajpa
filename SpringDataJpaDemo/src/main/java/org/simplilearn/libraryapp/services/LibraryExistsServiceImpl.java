package org.simplilearn.libraryapp.services;

import javax.transaction.Transactional;

import org.simplilearn.libraryapp.entities.Library;
import org.simplilearn.libraryapp.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibraryExistsServiceImpl implements LibraryExistService{
	@Autowired
	private LibraryRepository libraryRepository;

	@Override
	public boolean checkLibraryExistsById(int id) {
		
		return libraryRepository.existsById(id);
	}

	@Override
	public boolean checkLibraryExistsByExample(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaSeperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		boolean b=libraryRepository.exists(example);
		return b;
	}

}
