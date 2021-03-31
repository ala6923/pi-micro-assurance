package tn.esprit.spring.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entities.Document;
import tn.esprit.spring.repository.DocumentRepository;


@Service
public class DocumentServiceImpl implements IDocumentService{
	
	@Autowired
	DocumentRepository documentRep;

	@Override
	public List<Document> retrieveAllDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document addDocument(Document d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDocument(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Document updateDocument(Document d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document retrieveDocument(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
