package brawlstarsapi.infrastructure.members.gateways;

import brawlstarsapi.command.MembersCommand;
import com.mongodb.client.MongoCollection;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MembersFilesGateway {

    @Inject
    public MembersCommand membersCommand;
    public void exportMembersOds(){
        List<Document> membersDocuments = membersCommand.getMembers();

        Workbook membersWorkbook = new XSSFWorkbook();

        Sheet membersSheet = membersWorkbook.createSheet("membersSheet");

        int rowNumber = 0;
        for(Document member : membersDocuments){
            Row row = membersSheet.createRow(rowNumber++);
            int cellNum = 0;

            Cell cell = row.createCell(cellNum++);
            cell.setCellValue(member.get("tag").toString());

            cell = row.createCell(cellNum++);
            cell.setCellValue(member.get("name").toString());

            try{
                File membersOdsFile = new File("members.ods");
                FileOutputStream fileOutputStream = new FileOutputStream(membersOdsFile);

                membersWorkbook.write(fileOutputStream);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
