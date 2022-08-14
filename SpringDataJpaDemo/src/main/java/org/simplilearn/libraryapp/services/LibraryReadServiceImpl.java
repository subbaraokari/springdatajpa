package org.simplilearn.libraryapp.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.simplilearn.libraryapp.entities.Library;
import org.simplilearn.libraryapp.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibraryReadServiceImpl implements LibraryReadService{
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	public List<Library> getAllLibrary() {
		return libraryRepository.findAll();
	}

	@Override
	public List<Library> getAllLibrariesWithZeroBooks() {
		Library library=new Library();
		library.setCommaSeperatedBookNames("");
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		
		return libraryRepository.findAll(example);
	}

	@Override
	public Page<Library> getLibrariesPaged() {
		Pageable pageable=PageRequest.of(0, 3);
		return libraryRepository.findAll(pageable);
	}

	@Override
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfPages) {
		Pageable pageable=PageRequest.of(pageNumber, numberOfPages);
		return libraryRepository.findAll(pageable);
	}

	@Override
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return libraryRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		
		return libraryRepository.findAll(Sort.by(direction, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return libraryRepository.findAll(Sort.by(direction, "name"));
	}

	@Override
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaSeperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		Pageable pageable=PageRequest.of(0, 3, Sort.by("name"));
		return libraryRepository.findAll(example, pageable);
	}


	@Override
	public List<Library> getLibrariesSortedByNameAndWithTheseBooks(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaSeperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		return libraryRepository.findAll(example, Sort.by("name"));
	}

	@Override
	public List<Library> getLibraryByIds(List<Integer> ids) {
		return libraryRepository.findAllById(ids);
	}

	@Override
	public Optional<Library> getLibrary(int id) {
		return libraryRepository.findById(id);
	}

	@Override
	public Optional<Library> getLibraryWithTheseBooks(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaSeperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		return libraryRepository.findOne(example);
	}

	@Override
	public Page<Library> getLibrariesCustomPagedAndSortWithDefaultOrderByIdAndNameWithWithTheseBookNames(
			String commaSeperatedBookNames, int pageNumber, int numberOfPages) {
		Library library=new Library();
		library.setCommaSeperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		Pageable pageable=PageRequest.of(pageNumber, numberOfPages, Sort.by("id","name"));
		return libraryRepository.findAll(example, pageable);
	}

}
