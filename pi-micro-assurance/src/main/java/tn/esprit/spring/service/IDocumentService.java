package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.dao.entities.Document;

public interface IDocumentService {
	
	
	List<Document> retrieveAllDocuments();
	Document addDocument(Document d);
	 void deleteDocument(int id);
	 Document updateDocument(Document d);
	 Document retrieveDocument(int id);

}
