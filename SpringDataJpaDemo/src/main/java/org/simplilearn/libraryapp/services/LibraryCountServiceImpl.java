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
public class LibraryCountServiceImpl implements LibraryCountService{
	@Autowired
	private LibraryRepository libraryRepository;
	
	@Override
	public int countLibraries() {
		return (int) libraryRepository.count();
	}

	@Override
	public int countLibrariesWithZeroBooks() {
		Library library=new Library();
		library.setCommaSeperatedBookNames("");
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		
		return (int) libraryRepository.count(example);
	}

}
