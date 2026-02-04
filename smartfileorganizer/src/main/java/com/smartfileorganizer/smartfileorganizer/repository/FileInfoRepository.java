package com.smartfileorganizer.smartfileorganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartfileorganizer.smartfileorganizer.entity.FileInfo;

@Repository
public interface FileInfoRepository extends JpaRepository<FileInfo, Long>{

}
