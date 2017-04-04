package main.java.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StockUtils {

	public StockUtils() {
		// TODO Auto-generated constructor stub
	}
	
	private static List<String> stockList;

	final static String STOCK_LIST_FILE = System.getProperty("user.dir") + File.separator + "src" + 
											File.separator + "main" + File.separator + "resources" + 
											File.separator + "nasdaqlisted.csv";
	
	private static void initStockList() {
		if (stockList == null) {
			stockList = getStockListFromFile(STOCK_LIST_FILE);
		}
	}
	
	private static List<String> getStockListFromFile(String filePath) {
		List<String> data = new ArrayList<String>();
		try (FileReader fileReader = new FileReader(filePath); 
			BufferedReader reader = new BufferedReader(fileReader)){
			String stockName = null;
			while ((stockName = reader.readLine()) != null) {
				data.add(stockName);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return data;
	}
	
	public static ObservableList<String> getMatchedQuery(String query) {
		if (query.isEmpty()) {
			return null;
		}
		initStockList();
		System.out.println("Query: " + query);
		if (stockList != null) {
			List<String> matchedResult = stockList.stream().filter(it -> it.contains(query)).collect(Collectors.toList());
			return FXCollections.observableArrayList(matchedResult);
		}
		else return FXCollections.observableArrayList("Unexpected error happed!");
	}
}
