import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVFormat.Builder;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import com.example.demo.entity.CodeTable;

@Component
public class CSVHelper {
	public static ByteArrayInputStream codeTablesToCSV(List<CodeTable> codeTableList) {
		//		final CSVFormat format = CSVFormat.DEFAULT.withQuote(null).withDelimiter(',');

		final Builder builder = CSVFormat.Builder.create().setDelimiter(',').setQuote('\"');

		final CSVFormat format = builder.build();

		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
			for (CodeTable codeTable : codeTableList) {
				List<String> data = Arrays.asList(
						String.valueOf(codeTable.getId()),
						codeTable.getZipCode(),
						codeTable.getPrefectureName(),
						codeTable.getCityName(),
						codeTable.getTownName());

				csvPrinter.printRecord(data);
			}

			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		}
	}

}
