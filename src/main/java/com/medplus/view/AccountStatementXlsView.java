package com.medplus.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import org.springframework.web.servlet.view.xslt.AbstractXsltView;

import com.medplus.dto.AccountStatementDto;

public class AccountStatementXlsView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<AccountStatementDto> statements=null;
		HSSFSheet sheet=workbook.createSheet("statement");
		statements=(List<AccountStatementDto>) model.get("statements");
		HSSFRow row=null;
		HSSFCell cell=null;
		for(int i=1;i<statements.size();i++) {
			
			row=sheet.createRow(i);
			cell=row.createCell(1);
			cell.setCellValue(statements.get(i).getTxNo());
			cell=row.createCell(2);
			cell.setCellValue(statements.get(i).getTransactionDate());
			cell=row.createCell(3);
			cell.setCellValue(statements.get(i).getRemarks());
			cell=row.createCell(4);
			cell.setCellValue(statements.get(i).getDebit());
			cell=row.createCell(5);
			cell.setCellValue(statements.get(i).getCredit());
			cell=row.createCell(6);
			cell.setCellValue(statements.get(i).getAvailableBalance());
			
		}
		
	}
		
}
