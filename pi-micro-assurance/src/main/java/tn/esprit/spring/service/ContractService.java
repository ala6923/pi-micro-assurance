package tn.esprit.spring.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.spring.dao.entities.Category;
import tn.esprit.spring.dao.entities.Contract;
import tn.esprit.spring.dao.entities.ContractStatus;
import tn.esprit.spring.dao.entities.Insured;
import tn.esprit.spring.dao.entities.Insurer;
import tn.esprit.spring.dao.entities.Product;
import tn.esprit.spring.dao.entities.Sinister;
import tn.esprit.spring.dao.entities.User;
import tn.esprit.spring.repository.SinisterRepository;
import tn.esprit.spring.repository.ContractRepository;
import tn.esprit.spring.repository.InsuredRepository;
import tn.esprit.spring.repository.InsurerRepository;
import tn.esprit.spring.repository.ProductRepository;
public class ContractService implements IContractService {
	@Autowired
	SinisterRepository Sr;
	@Autowired
	ContractRepository cntR;
	@Autowired
	ProductRepository prdR;
	@Autowired
	InsurerRepository inrR;
	@Autowired
	InsuredRepository indR;
	
	
	
	public double CalculatePurePrimium(Date BeginigOfYear,Date endDate,Category cat,Insurer ins){
		List<Sinister> ls=Sr.findAll();
		int i=0;
		
		
		double totalCost=0;
		for(Sinister itr :ls)
		{
		
		if (itr.getSinisterDate().after(BeginigOfYear)&&itr.getSinisterDate().before(endDate)&&(itr.getContract().getInsurer().equals(ins))&&(itr.getContract().getCategory().equals(cat)))
			totalCost+=itr.getSinisterCost();
			i++;
		}
		
		
		return totalCost/i;
	} 

	
	@Override
	public List<Contract> findContractByCategory(Category categorie) {
		List<Contract> ls=cntR.findAll();
		List<Contract> retoure=new ArrayList<Contract>();
		for(Contract itr :ls)
		{
		
		if(itr.getCategory().equals(categorie))
			retoure.add(itr);
			
		}
		return retoure;
	}


	@Override
	public double calculateNetPrimium(Contract c,Date ppBiginigReferenceYear,Date ppEndReferenceYear, List<Product> panier) {
		double purePrimium=0;
		double Commission;
		double FNG;
		double netprim;
		for(Product prod :panier){
			Insurer ins=inrR.findById(prod.getInsurer_ID()).get();
			purePrimium+=CalculatePurePrimium(ppBiginigReferenceYear,ppBiginigReferenceYear,prod.getCategory(),ins);
			
			
		}
		switch(c.getInsured().getSegment()){
		/*case Risky1:
			c.setDi;
			break;
		case Risky2:
			break;*/
		case 2:
			purePrimium+=purePrimium*0.01;
			break;
		case 3:
			purePrimium+=purePrimium*0.02;
			break;
		case 4:
			purePrimium+=purePrimium*0.04;
			break;
		/*case fraud:
			
			break;*/
		default:
			break;
		
		}
		//c.setInsured(insured);
		Commission=c.getComission()*purePrimium/100;
		FNG=c.getNetMangamentFees()*purePrimium/100;
		netprim=purePrimium+Commission+FNG ;
		c.setComission(Commission);
		c.setNetMangamentFees(FNG);
		c.setNetPremiuim(netprim);
		
		return netprim;
	}

	@Override
	public Contract calculateTotalPrimuim(Contract c,double tax) {
		double totalPrimium=0;
		c.setTax(tax);
		switch(c.getInsured().getSegment()){
		case 0:
			c.setDiscount(c.getNetPremiuim()*0.04);
			break;
		case 1:
			c.setDiscount(c.getNetPremiuim()*0.02);
			break;
		
		default:
			c.setDiscount(0);
			break;
		
		}
		totalPrimium=c.getNetPremiuim()+tax-c.getDiscount();
		c.setTotalPemium(totalPrimium);
		return c;
	}

	@Override
	public Contract generateContract(Contract c,Insured insured, List<Product> product) throws ParseException {
		// TODO Auto-generated method stub
		//calcule du tax
		Date ppEndReferenceYear=null;
		Date ppBiginigReferenceYear=null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

		//String dateBiginigString = "01-01-2020";
			ppEndReferenceYear = formatter.parse("01-01-2021");
			ppBiginigReferenceYear = formatter.parse("01-01-2020");
	
			
			
			
			
			
			//insured.setSegment(n);
		
		if(verifyIfProductsOfSameInsurer(product)){
		double tax;
		
		//Contract c =new Contract();
		c.setInsured(insured);
	
		c.setPayedAmount(0);
		tax=calculateNetPrimium(c,ppBiginigReferenceYear,ppEndReferenceYear, product)*0.1;
		calculateTotalPrimuim(c,tax);
		c.setStatus(ContractStatus.Waiting_For_Confirmation);
		//c;
		/*à verifier*/c.setInsurer(inrR.findById(product.get(0).getInsurer_ID()).orElseThrow(null));
		
		}
		
		return cntR.save(c);
	}

	@Override
	public Contract signContract(Insured insured, Insurer insurer, Contract contract) {
		contract.setStatus(ContractStatus.Valid_Contract);
		contract.setReminingAmount(0);
		updateContract(contract);
		return contract;
	}

	@Override
	public void archiveContract(Contract c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteContract(Contract c) {
		cntR.delete(c);

	}

	@Override
	public void updateContract(Contract c) {
		c.setLastUpdate(Date.from(Calendar.getInstance().toInstant()));
		cntR.save(c);

	}

	
	@Override
	public void unsignContract(Contract c) {
		c.setStatus(ContractStatus.Ended);
		c.setReminingAmount(0);
		updateContract(c);

	}

	@Override
	public List<Contract> findInsuredContracts(Insured ind) {
		List<Contract> ls=cntR.findAll();
		List<Contract> retoure = new ArrayList<Contract>();
		for(Contract itr :ls)
		{
		
		if (itr.getInsured().equals(ind))
			retoure.add(itr);
		}
		
		
		
		return retoure;
	}

	@Override
	public List<Contract> findInsurerContracts(Insured inr) {
				List<Contract> ls=cntR.findAll();
				List<Contract> retoure = new ArrayList<Contract>();
				for(Contract itr :ls)
				{
				
				if (itr.getInsurer().equals(inr))
					retoure.add(itr);
				}
				
				
				
				return retoure;
	}

	@Override
	public void evaluteContract(Contract c) {
		// TODO Auto-generated method stub

	}

	@Override
	public int CountContractsBetween(String EndDate_ddmmyyyy, String BiginingDate_yymmdd) {
		List<Contract> liste=cntR.findAll();
		Date EndDate=null;
		Date BiginingDate=null;
		int counter=0;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		try {
			EndDate = formatter.parse(EndDate_ddmmyyyy);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			BiginingDate = formatter.parse(BiginingDate_yymmdd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for(Contract itr :liste)
		{
		
		if (itr.getSignDate().after(BiginingDate)&&itr.getSignDate().before(EndDate))
			
			counter++;
		}
		
		return counter;
	}

	@Override
	public List<Contract> viewContractsByCategory(Category cat) {
		List<Contract> ls=cntR.findAll();
		List<Contract> retoure = new ArrayList<Contract>();
		for(Contract itr :ls)
		{
		
		if (itr.getCategory().equals(cat))
			retoure.add(itr);
		}
		
		
		
		return retoure;
	}
	
	@Override
	public List<Contract> viewContractsByStatus(ContractStatus stat) {
		List<Contract> ls=cntR.findAll();
		List<Contract> retoure = new ArrayList<Contract>();
		for(Contract itr :ls)
		{
		
		if (itr.getStatus().equals(stat))
			retoure.add(itr);
		}
		
		
		
		return retoure;
	}
	
	
	public boolean verifyIfProductsOfSameInsurer(List<Product> liste){ 
		Product buffer=liste.get(1);
		 for(Product itr :liste)
			 
			 if(buffer.getInsurer_ID()!=itr.getInsurer_ID())
				 return false;
		
		
		
		return true;
		 }


	@Override
	public Document generatePDFversion(Contract c) throws IOException, DocumentException {
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\temp\\"+String.valueOf(c.getInsurer().getId())+".pdf"));
		document.open();

		Paragraph title1 = new Paragraph("Insurance Contract Gardian Angel",
		FontFactory.getFont(FontFactory.HELVETICA,
		18, Font.BOLDITALIC, new CMYKColor(0, 255, 255,17)));
		Chapter chapter1 = new Chapter(title1, 1);
		chapter1.setNumberDepth(0);
		
		
		
		
		Paragraph title11 = new Paragraph("POLICY",
		FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD,
		new CMYKColor(0, 255, 255,17)));
		Section section1 = chapter1.addSection(title11);
		Paragraph SectionPolicy = new Paragraph(c.getPolicy());
		section1.add(SectionPolicy);
		SectionPolicy = new Paragraph("DISCTRIPTION:");
		section1.add(SectionPolicy);
		SectionPolicy = new Paragraph("InsureD Full Name: "+c.getInsured().getName()+" "+c.getInsured().getFirstname());
		section1.add(SectionPolicy);
		SectionPolicy = new Paragraph("Insurer Name: "+c.getInsurer().getName()+" "+c.getInsurer().getFirstname());
		section1.add(SectionPolicy);
		SectionPolicy = new Paragraph("Insurer Matricul: "+c.getInsurer().getMatricul());
		section1.add(SectionPolicy);
		PdfPTable t = new PdfPTable(9);
		t.setSpacingBefore(25);
		t.setSpacingAfter(25);
		PdfPCell c2 = new PdfPCell(new Phrase("Contract_ID"));
		t.addCell(c2);
		PdfPCell c7 = new PdfPCell(new Phrase("Insurer ID"));
		t.addCell(c7);
		PdfPCell c8 = new PdfPCell(new Phrase("Insured ID"));
		t.addCell(c8);
		PdfPCell c10 = new PdfPCell(new Phrase("Insured CIN"));
		t.addCell(c10);
		PdfPCell c1 = new PdfPCell(new Phrase("Signatur Date"));
		t.addCell(c1);
		PdfPCell c3 = new PdfPCell(new Phrase("Contract category"));
		t.addCell(c3);
		PdfPCell c4 = new PdfPCell(new Phrase("Net amount"));
		t.addCell(c4);
		PdfPCell c44 = new PdfPCell(new Phrase("Total amount"));
		t.addCell(c44);
		PdfPCell c5 = new PdfPCell(new Phrase("Tax"));
		t.addCell(c5);
		PdfPCell c6 = new PdfPCell(new Phrase("Discount"));
		t.addCell(c6);
		t.addCell(String.valueOf(c.getId()));
		t.addCell(String.valueOf(c.getInsurer().getId()));
		t.addCell(String.valueOf(c.getInsured().getId()));
		t.addCell(String.valueOf(c.getInsured().getCin()));
		t.addCell(c.getSignDate().toString());
		t.addCell(c.getSignDate().toString());
		t.addCell(c.getCategory().toString());
		t.addCell(String.valueOf(c.getNetPremiuim()));
		t.addCell(String.valueOf(c.getTotalPemium()));
		t.addCell(String.valueOf(c.getTax()));
		t.addCell(String.valueOf(c.getDiscount()));
		
		
		section1.add(t);
		
		Image logo = Image.getInstance("c:\\tempo\\logo.bmp");
		logo.scaleAbsolute(100, 100);
		section1.add(logo);
		
		BarcodeQRCode barcodeQRCode = new BarcodeQRCode(String.valueOf(c.getInsurer().getId())+String.valueOf(c.getId()), 1000, 1000, null);
        Image codeQrImage = barcodeQRCode.getImage();
        codeQrImage.scaleAbsolute(100, 100);
        document.add(codeQrImage);
		/*
		Paragraph title2 = new Paragraph("Using Anchor", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new CMYKColor(0, 255, 0, 0)));
		section1.add(title2);
		title2.setSpacingBefore(5000);
		Anchor anchor2 = new Anchor("Back To Top");
		anchor2.setReference("#BackToTop");
		section1.add(anchor2);*/
		document.add(chapter1);
		document.close();
		return document;
	}
	
	//TODO methode find risky Contracts 
	
	
	

}
