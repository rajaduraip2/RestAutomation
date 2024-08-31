package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException {
        String path= System.getProperty("user.dir")+"//testData//CreateUserTestData.xlsx";
        XLUtility xl= new XLUtility(path);
        int rowNum= xl.getRowCount("Sheet1");
        int colNum= xl.getCellCount("Sheet1",1);
        String apidata[][]= new String[rowNum][colNum];
            for (int i=1;i<=rowNum;i++){
                for (int j=0;j<colNum;j++){
                    apidata[i-1][j]=xl.getCellData("Sheet1",i,j);
                }
            }
            return  apidata;
    }

    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException {
        String path= System.getProperty("user.dir")+"//testData//CreateUserTestData.xlsx";
        XLUtility xl= new XLUtility(path);
        int rownum=xl.getRowCount("Sheet1");
        String[] userNames= new String[rownum];
        for (int i=1;i<=rownum;i++)
        {
            userNames[i-1]=xl.getCellData("Sheet1",i,1);
        }
        return userNames;

    }
}
