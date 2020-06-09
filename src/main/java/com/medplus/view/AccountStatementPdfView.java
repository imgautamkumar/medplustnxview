package com.medplus.view;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.medplus.dto.AccountStatementDto;

public class AccountStatementPdfView extends AbstractPdfView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<AccountStatementDto> statements=null;
		PdfPTable table=new PdfPTable(6);
		table.addCell("txNo");
		table.addCell("transactionDate");
		table.addCell("remarks");
		table.addCell("debit");
		table.addCell("credit");
		table.addCell("availableBalance");
		document.add(table);
		statements=(List<AccountStatementDto>) model.get("statements");
		for(int i=0;i<statements.size();i++) {
			AccountStatementDto dto=statements.get(i);
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			table.addCell(String.valueOf(dto.getTxNo()));
			table.addCell(sdf.format(dto.getTransactionDate()));
			table.addCell(dto.getRemarks());
			table.addCell(String.valueOf(dto.getDebit()));
			table.addCell(String.valueOf(dto.getCredit()));
			table.addCell(String.valueOf(dto.getAvailableBalance()));
			document.add(table);			
		}			
	}

}
