package Lesson22;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ByteArrayOutputStream implements Copy{
    @Override
    public void copy(String from, String to) throws IOException {

            Path sourceFile = Paths.get("C:\\Users\\dj-nf\\Downloads\\jdk-19_windows-x64_bin.exe");
            java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();

            long numberOfBytes = Files.copy(sourceFile, outputStream);

            System.out.println("Successful copy " + numberOfBytes + " bytes ");


        }
    }