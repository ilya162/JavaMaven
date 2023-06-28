package Lesson22;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CopyBufferIO bufferIO = new CopyBufferIO();
        FileCopyChannel fileCopyChannel = new FileCopyChannel();
        FileCopyNio fileCopyNio = new FileCopyNio();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            long start1 = System.currentTimeMillis();
            bufferIO.copy("C:\\Users\\dj-nf\\Downloads\\jdk-19_windows-x64_bin.exe", "qwe1.zip");
            long end1 = System.currentTimeMillis();
            System.out.println("CopyBufferIO " + (end1 - start1));

            long start2 = System.currentTimeMillis();
            fileCopyChannel.copy("C:\\Users\\dj-nf\\Downloads\\jdk-19_windows-x64_bin.exe", "qwe2.zip");
            long end2 = System.currentTimeMillis();
            System.out.println("CopyChannelNIO " + (end2 - start2));


            long start3 = System.currentTimeMillis();
            fileCopyNio.copy("C:\\Users\\dj-nf\\Downloads\\jdk-19_windows-x64_bin.exe", "qwe3.zip");
            long end3 = System.currentTimeMillis();
            System.out.println("FileCopyNio " + (end3 - start3));

            long start4 = System.currentTimeMillis();
            byteArrayOutputStream.copy("C:\\Users\\dj-nf\\Downloads\\jdk-19_windows-x64_bin.exe", "qwe4.zip");
            long end4 = System.currentTimeMillis();
            System.out.println("byteArrayOutputStream " + (end4 - start4));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
