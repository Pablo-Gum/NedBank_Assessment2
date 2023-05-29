package DataReader;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelReader {
    public static Recordset readExcel(String filePath, String query) {
        Recordset recordset;

        try {
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection(filePath);
            recordset = connection.executeQuery(query);

        } catch (FilloException e) {
            throw new RuntimeException(e);
        }
        return  recordset;


    }
}
