package proofpoint;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class ProofPoint2 {

    public static void main(String[] args) {


        List<DomainDto> mergedDataSet = getMergedData("src/proofpoint/current.txt", "src/proofpoint/update.txt");

        List<DomainDto> unchangedRecords = mergedDataSet.stream().filter(d -> d.getUpdateStatus() == null).collect(Collectors.toList());

        System.out.println(unchangedRecords.size());
    }

    private static List<DomainDto> getMergedData(String currentFile, String updateFile) {

        String line;


        List<DomainDto> returnableData = new ArrayList<>();

        Map<String, DomainDto> currentStatus = new HashMap<>();


        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(currentFile), Charset.forName("UTF-8")))) {
            while ((line = br.readLine()) != null) {

                String[] currentRow = line.split(",");

                currentStatus.put(currentRow[0], new DomainDto(currentRow[0],currentRow[2], null, currentRow[1], null));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(updateFile), Charset.forName("UTF-8")))) {
            while ((line = br.readLine()) != null) {

                String[] currentRow = line.split(",");

                if (currentStatus.containsKey(currentRow[0])) {

                    DomainDto existing = currentStatus.get(currentRow[0]);
                    existing.setUpdateStatus(currentRow[2]);
                    existing.setUpdatedHash(currentRow[1]);
                } else {
                    returnableData.add(new DomainDto(currentRow[0], currentRow[2], currentRow[2], currentRow[1], currentRow[1]));
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        returnableData.addAll(currentStatus.values());

        return returnableData;
    }



}
