package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

public class PresidentDAOFileImpl implements PresidentDAO{
	private List<President> presidents;
	private ServletContext context;
	
	public PresidentDAOFileImpl(ServletContext context){
		this.context = context;
		this.loadInventoryFromFile("WEB-INF/presidents1.txt");
	}

	private void loadInventoryFromFile(String fileName){
		presidents = new ArrayList<>();
		try {
			InputStream is = context.getResourceAsStream(fileName);
			BufferedReader r = new BufferedReader(new InputStreamReader(is));
			String line = "";
			while ((line = r.readLine()) != null){
				String[] fields = line.split("&");
				President p = new President(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5]);
				presidents.add(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.err.println("DEBUG:" + presidents);
	}

	@Override
	public List<President> getPresidents() {
		return presidents;
	}
}

