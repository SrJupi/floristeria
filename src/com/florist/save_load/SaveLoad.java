package com.florist.save_load;

import com.florist.Florist;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SaveLoad {
    public static void saveFlorist(Florist serObj) {

        String actualDir = System.getProperty("user.dir");
        String saveFilePath = actualDir + "\\" + serObj.getName() + ".flor";
        try {
            FileOutputStream fileOut = new FileOutputStream(saveFilePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
        } catch (Exception ex) {
            System.out.println("Florist can not be saved.");
        }
    }

    public static void searchFlorist() {

        String actualDir = System.getProperty("user.dir");
        List<String> foundFiles = listFiles(Path.of(actualDir));
        if (foundFiles.size() == 1){
            loadFlorist(foundFiles.get(0));
        }
        else if (foundFiles.size() > 1){
            int i = 0;
            Scanner sc = new Scanner(System.in);
            String input = null;
            System.out.println("It was found these florist archives:");
            for (String s :
                    foundFiles) {
                System.out.println(s.substring(s.lastIndexOf("\\") + 1 , s.lastIndexOf(".")));
            }
            boolean invalidInput = true;
            while (invalidInput){
                System.out.println("Which file do you want to load?");
                input = sc.nextLine();
                i = 0;
                while (invalidInput && i < foundFiles.size()){
                    String s = foundFiles.get(i);
                    if (s.substring(s.lastIndexOf("\\") + 1, s.lastIndexOf("."))
                            .equals(input)){
                        invalidInput = false;
                    }
                    i++;
                }
            }

            boolean notLoaded = true;
            i = 0;
            while (notLoaded && i < foundFiles.size()){
                String files = foundFiles.get(i);
                if (files.substring(files.lastIndexOf("\\") + 1, files.lastIndexOf("."))
                        .equals(input)){
                    loadFlorist(foundFiles.get(i));
                    notLoaded = false;
                }
                i++;
            }
        }
        else{
            System.out.println("");
        }
    }

    private static Florist loadFlorist(String file_path) {
        try {
            InputStream fileIn = Files.newInputStream(Path.of(file_path));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object returnFloristeria = objectIn.readObject();
            objectIn.close();
            System.out.println("The Object was successfully read at: " + file_path);
            return (Florist) returnFloristeria;
        } catch (Exception ex) {
            System.out.println("Object could not be read: "+ file_path);
            return null;
        }
    }

    public static List<String> listFiles(Path path){
        try (Stream<Path> filepath = Files.walk(path, 1)){
            return filepath.filter(s -> !Files.isDirectory(s))
                    .map(s -> s.toString())
                    .filter(s -> s.contains(".flor"))
                    .collect(Collectors.toList());
        }catch (IOException e) {
            System.out.println("Directory does not exist!");
        }
        return null;
    }
}
