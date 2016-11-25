package com.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.beans.Train;

@Repository
public interface TrainRepository extends MongoRepository<Train, String> {
	Long deleteTrainById(String id);
	Train findTrainById(String id);
}