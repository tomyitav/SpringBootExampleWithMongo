package com.example.service;

import java.util.List;

import com.example.beans.Train;

public interface TrainService {
    public List<Train> getAllTrains();

    public Train getTrainById(String id);

    public void addTrain(Train train);

    public void deleteTrainById(String id);

    public void deleteAll();

    public void updateTrain(Train train);
}