package hr.akd.selekcijski.zadatak.util;

import hr.akd.selekcijski.zadatak.entity.User;
import hr.akd.selekcijski.zadatak.exceptions.BadRequestException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvUtil {

    public static String TYPE = "application/vnd.ms-excel";
    public static boolean isCsvFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<User> csvToUsers(InputStream is) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(bufferedReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().withDelimiter(';'))) {
            List<User> users = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                    User newUser = new User(
                            csvRecord.get("Ime"),
                            csvRecord.get("Prezime"),
                            StringToDate(csvRecord.get("DatumRodjenja"))
                    );
                    users.add(newUser);
            }
            return users;

        }catch (ParseException e){
            throw new BadRequestException("Fail to parse csv file: wrong date format");
        }catch (Exception e) {
            throw new BadRequestException("Fail to parse csv file");
        }
    }

    private static Date StringToDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date newDate = simpleDateFormat.parse(date);
        return newDate;
    }
}
