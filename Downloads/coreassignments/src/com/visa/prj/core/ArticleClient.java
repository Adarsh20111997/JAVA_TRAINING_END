package com.visa.prj.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.visa.prj.entity.Article;

public class ArticleClient {

	public static void main(String[] args) {
		List<Article> articles = new ArrayList<>();
		articles.add(new Article("NoDBA",561,"bliki",Arrays.asList("nosql","people","orm")));
		articles.add(new Article("Infodesk",1145,"bliki",Arrays.asList("nosql","writing")));
		articles.add(new Article("OrmHate",1718,"bliki",Arrays.asList("nosql","orm")));
		articles.add(new Article("ruby",1313,"article",Arrays.asList("ruby")));
		articles.add(new Article("DDD_Aggregate",482,"bliki",Arrays.asList("nosql","ddd")));
		
		printTotalWordCount(articles); // 5219
		printArticlesByType(articles); //{bliki:4, article: 1}
		
		// use flatMap, Function.identity and groupingby and Collectors.counting to solve this
		printTagCount(articles); // nosql: 4, ruby : 1, 
	}

	private static void printTagCount(List<Article> articles) {
		Map<String, Integer> map = new HashMap<String, Integer> ();
		for(Article article : articles) {
			for (String s : article.getTags()) {
		    
				if (!map.containsKey(s)) {  // first time we've seen this string
					map.put(s, 1);
				}
				else {
					int count = map.get(s);
					map.put(s, count + 1);
				}
			}
		}
		for (Map.Entry<String,Integer> entry : map.entrySet())  {
            System.out.println(entry.getKey() + " : " + entry.getValue()); 
		} 
	}
		

	private static void printArticlesByType(List<Article> articles) {
		 Map<String,List<Article>> typeMap = 
				 articles.stream().collect(Collectors.groupingBy(p->p.getType()));
		 
		 Set<String> keys = typeMap.keySet();
		 for(String key : keys) {
			 List<Article> prds = typeMap.get(key);
				System.out.println(key + " : " + prds.size());
				
			}
	}

	private static void printTotalWordCount(List<Article> articles) {
		int count=0;
		for(int i=0;i<articles.size();i++) {
			count += articles.get(i).getWords();
		}
		System.out.println(count);
	}

}
