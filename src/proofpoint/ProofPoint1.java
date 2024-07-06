package proofpoint;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class ProofPoint1 {

    public static void main(String[] args) {


        //System.out.println(getWordCount("src/resource/bigdata.txt"));
        System.out.println(getWordCount("src/resource/aliceinwonderland.txt"));

    }

    private static List<WordCount> getWordCount(String fileName) {

        String line;

        int wordCount = 0;

        Map<String, WordCount> wordCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), Charset.forName("UTF-8")))) {
            while ((line = br.readLine()) != null) {
                String[] lineWords = line.split(" ");

                for (String w : lineWords) {

                    String word = w.toLowerCase();

                    if (!w.equals("")) {

                        if (wordCountMap.containsKey(word)) {
                            WordCount wc = wordCountMap.get(word);
                            int count = wc.getCount();
                            wc.setCount(++count);

                        } else {
                            wordCountMap.put(word, new WordCount(1, word));
                        }


                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collection<WordCount> wordCountList = wordCountMap.values();

        List<WordCount> workFrequency = wordCountList
                                            .stream()
                                            .sorted(Comparator.comparing(WordCount::getCount).reversed())
                                            .limit(10)
                                            .collect(Collectors.toList());

        return workFrequency;
    }



}
