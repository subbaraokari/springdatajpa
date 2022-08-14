package org.simplilearn.libraryapp.repositories;

import org.simplilearn.libraryapp.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Integer>{

}
