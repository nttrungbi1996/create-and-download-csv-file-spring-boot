import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.csv.CreateCsv;
import com.example.demo.database.Database;
import com.example.demo.entity.CodeTable;
import com.example.demo.helper.CSVHelper;

@Controller
public class Controller {

  @Autowired
  Database database;
  
  @Autowired
  CreateCsv createCsv;
  
	@GetMapping("/download/csv")
	public ResponseEntity<Resource> downloadcsv(
			@RequestParam(required = false, defaultValue = "0") int from,
			@RequestParam(required = false, defaultValue = "0") int to) {

		List<CodeTable> codeTableList = null;

		if (from == 0 && to == 0) {
			codeTableList = database.getAllCodeTables();
		} else {
			codeTableList = database.getByIdStartEnd(from, to);
		}

		ByteArrayInputStream in = CSVHelper.codeTablesToCSV(codeTableList);

		String filename = createCsv.create();
		
		InputStreamResource file = new InputStreamResource(in);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/csv"))
				.body(file);

	}

}
