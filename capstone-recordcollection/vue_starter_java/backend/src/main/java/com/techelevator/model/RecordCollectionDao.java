package com.techelevator.model;

import java.util.List;

public interface RecordCollectionDao {

	List<RecordCollection> getAllRecords();

	RecordCollection getOneRecords(int id);

}
