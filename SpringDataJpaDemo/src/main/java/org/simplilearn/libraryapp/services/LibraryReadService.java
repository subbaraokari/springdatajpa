package org.simplilearn.libraryapp.services;

import java.util.List;
import java.util.Optional;

import org.simplilearn.libraryapp.entities.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

public interface LibraryReadService {
	List<Library> getAllLibrary();
	List<Library> getAllLibrariesWithZeroBooks();
	Page<Library> getLibrariesPaged();
	Page<Library> getLibrariesCustomPaged(int pageNumber,int numberOfPages);
	List<Library> getLibrariesWithLatestAddedOrder();
	List<Library> getLibrariesCustomSortedById(Direction direction);
	List<Library> getLibrariesCustomSortedByName(Direction direction);
	Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookNames);
	Page<Library> getLibrariesCustomPagedAndSortWithDefaultOrderByIdAndNameWithWithTheseBookNames(
			String commaSeperatedBookNames,int pageNumber,int numberOfPages);
	List<Library> getLibrariesSortedByNameAndWithTheseBooks(String commaSeperatedBookNames);
	List<Library> getLibraryByIds(List<Integer> ids);
	Optional<Library> getLibrary(int id);
	Optional<Library> getLibraryWithTheseBooks(String commaSeperatedBookNames);
}
