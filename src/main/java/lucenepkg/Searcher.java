package lucenepkg;

import java.nio.file.Paths;
import java.io.*;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;


public class Searcher {
	public static Version luceneVersion = Version.LATEST;
	
	public String indexSearch(String keywords){
		String res = "";
		DirectoryReader reader = null;
		try{
			Directory directory = FSDirectory.open(Paths.get("index"));
			reader = DirectoryReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);
			QueryParser parser = new QueryParser("content",new StandardAnalyzer());
			Query query = parser.parse(keywords);
			TopDocs tds = searcher.search(query, 20);
			ScoreDoc[] sds = tds.scoreDocs;
			int cou = 0;
			for(ScoreDoc sd :sds){
				cou++;
				Document d = searcher.doc(sd.doc);
				res  += cou+"."+d.get("name") + "\n";
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				reader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return res;
	}
	public static void main(String[] args) throws IOException
	{
		Searcher sea = new Searcher();
		System.out.println(sea.indexSearch("hello"));
	}

}
