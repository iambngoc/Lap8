package Lap8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import Lap7.WordCount;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
		public static final String fileName = "src\\Lap8\\fit.txt";
		// <word, its occurences>
		private Map<String, Integer> map = new HashMap<String, Integer>();
		public MyWordCountApp() throws FileNotFoundException {
			loadData();
		}

		// Load data from fileName into the above map (containing <word, its occurences>)
		// using the guide given in TestReadFile.java
		public void loadData() throws FileNotFoundException {
		    Scanner input = new Scanner(new File(fileName));
			while (input.hasNext()) {
				String word = input.next(); 
				map.put(word, map.getOrDefault(word, 0)+1);
			}
		}

		// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
		public int countDistinct() {
			return map.size();
		}

		// Prints out the number of times each unique token appears in the file
		// data/hamlet.txt (or fit.txt)
		// In this method, we do not consider the order of tokens.
		public void printWordCounts() throws FileNotFoundException {
			System.out.println("" + map +"");
		}

		// Prints out the number of times each unique token appears in the file
		// data/hamlet.txt (or fit.txt) according to ascending order of tokens
		// Example: An - 3, Bug - 10, ...
		public void printWordCountsAlphabet() {
			Map<String, Integer> treeMap = new TreeMap<>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			treeMap.putAll(map);
			Set<Map.Entry<String, Integer>> set = treeMap.entrySet();
			System.out.println(Arrays.toString(set.toArray()));
		}
		
	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp wc = new MyWordCountApp();
		wc.printWordCounts();
		wc.printWordCountsAlphabet();
//		System.out.println(wc);
	}
}
