import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public Main() {
        int number = 0;
        System.out.println("Enter a number:");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        createNewFile(number);
    }

    public void createNewFile(int number){
        File folder = new File("wmvfiles");
        File[] listofFiles = folder.listFiles();

        ArrayList<File> filltoAdded = new ArrayList<>();

        if(number < 100){
            for(File file: listofFiles){
                if(file.getName().equals(number+".wav")){
                    try {
                        Files.copy(file.toPath(), new File("generatedfiles/"+ file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if(number >= 100 && number<1000){
            int firstNumber = number / 100;
            int secondNumber = 100;
            int thirdNumber = number % 100;

            ArrayList<Integer> myNumber = new ArrayList<>();
            myNumber.add(firstNumber);
            myNumber.add(secondNumber);
            myNumber.add(thirdNumber);

            AudioInputStream appendFiles = null;

            if(thirdNumber == 0){
                for(int i=0; i<2; i++){
                    for(File file: listofFiles){
                        if(file.getName().equals(myNumber.get(i)+".wav")){
                            filltoAdded.add(file);
                        }
                    }
                }
                try {
                    AudioInputStream clip1 = AudioSystem.getAudioInputStream(filltoAdded.get(0));
                    AudioInputStream clip2 = AudioSystem.getAudioInputStream(filltoAdded.get(1));

                    appendFiles = new AudioInputStream(new SequenceInputStream(clip1, clip2), clip1.getFormat(), clip1.getFrameLength() + clip2.getFrameLength());
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                for(int i=0; i<3; i++){
                    for(File file: listofFiles){
                        if(file.getName().equals(myNumber.get(i)+".wav")){
                            filltoAdded.add(file);
                        }
                    }
                }

                try {
                    AudioInputStream clip1 = AudioSystem.getAudioInputStream(filltoAdded.get(0));
                    AudioInputStream clip2 = AudioSystem.getAudioInputStream(filltoAdded.get(1));
                    AudioInputStream clip3 = AudioSystem.getAudioInputStream(filltoAdded.get(2));

                    appendFiles = new AudioInputStream(new SequenceInputStream(clip1, clip2), clip1.getFormat(), clip1.getFrameLength() + clip2.getFrameLength());
                    appendFiles = new AudioInputStream(new SequenceInputStream(appendFiles, clip3), appendFiles.getFormat(), appendFiles.getFrameLength() + clip3.getFrameLength());
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                AudioSystem.write(appendFiles, AudioFileFormat.Type.WAVE, new File("generatedfiles/newfile.wav"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(number>=1000 && number <100000){
            int firstNumber = number / 1000;

            File file1 = null;
            File file2 = null;

            for(File file: listofFiles){
                if(file.getName().equals(firstNumber+".wav"))
                    file1 = file;
                if(file.getName().equals("1000.wav"))
                    file2 = file;
            }

            AudioInputStream appendFiles = null;

            try {
                AudioInputStream clip1 = AudioSystem.getAudioInputStream(file1);
                AudioInputStream clip2 = AudioSystem.getAudioInputStream(file2);

                appendFiles = new AudioInputStream(new SequenceInputStream(clip1, clip2), clip1.getFormat(), clip1.getFrameLength() + clip2.getFrameLength());
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int leftNumber = number % 1000;
            firstNumber = leftNumber;

            AudioInputStream tempAppendFiles = null;

            if(leftNumber >= 100 && leftNumber <= 999){
                leftNumber = leftNumber / 100;
                firstNumber = firstNumber % 100;

                for(File file: listofFiles){
                    if(file.getName().equals(leftNumber+".wav"))
                        file1 = file;
                    if(file.getName().equals("100.wav"))
                        file2 = file;
                }

                try {
                    AudioInputStream clip1 = AudioSystem.getAudioInputStream(file1);
                    AudioInputStream clip2 = AudioSystem.getAudioInputStream(file2);

                    tempAppendFiles = new AudioInputStream(new SequenceInputStream(clip1, clip2), clip1.getFormat(), clip1.getFrameLength() + clip2.getFrameLength());
                    appendFiles = new AudioInputStream(new SequenceInputStream(appendFiles, tempAppendFiles), appendFiles.getFormat(), appendFiles.getFrameLength() + tempAppendFiles.getFrameLength());
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if(firstNumber >=1 && firstNumber <=99){
                for(File file: listofFiles){
                    if(file.getName().equals(firstNumber+".wav"))
                        file1 = file;
                }
                try {
                    AudioInputStream clip1 = AudioSystem.getAudioInputStream(file1);
                    appendFiles = new AudioInputStream(new SequenceInputStream(appendFiles, clip1), appendFiles.getFormat(), appendFiles.getFrameLength() + appendFiles.getFrameLength());
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                AudioSystem.write(appendFiles, AudioFileFormat.Type.WAVE, new File("generatedfiles/newfile.wav"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(number >= 100000 && number <10000000){
            int firstNumber = number / 100000;

            File file1 = null;
            File file2 = null;

            for(File file: listofFiles){
                if(file.getName().equals(firstNumber+".wav"))
                    file1 = file;
                if(file.getName().equals("100000.wav"))
                    file2 = file;
            }

            AudioInputStream appendFile = null;

            try {
                AudioInputStream clip1 = AudioSystem.getAudioInputStream(file1);
                AudioInputStream clip2 = AudioSystem.getAudioInputStream(file2);

                appendFile = new AudioInputStream(new SequenceInputStream(clip1, clip2), clip1.getFormat(), clip1.getFrameLength() + clip2.getFrameLength());
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int leftNumber = number % 100000;
            firstNumber = leftNumber;

            if(leftNumber >= 1000 && leftNumber <=99999){
                leftNumber = leftNumber / 1000;
                firstNumber = firstNumber % 1000;

                for(File file: listofFiles){
                    if(file.getName().equals(leftNumber+".wav"))
                        file1 = file;
                    if(file.getName().equals("1000.wav"))
                        file2 = file;
                }

                try {
                    AudioInputStream clip1 = AudioSystem.getAudioInputStream(file1);
                    AudioInputStream clip2 = AudioSystem.getAudioInputStream(file2);

                    AudioInputStream tempAppendFile = new AudioInputStream(new SequenceInputStream(clip1, clip2), clip1.getFormat(), clip1.getFrameLength() + clip2.getFrameLength());
                    appendFile = new AudioInputStream(new SequenceInputStream(appendFile, tempAppendFile), appendFile.getFormat(), appendFile.getFrameLength() + tempAppendFile.getFrameLength());

                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if(firstNumber >= 100 && firstNumber <= 999){
                leftNumber = firstNumber / 100;
                firstNumber = firstNumber % 100;

                for(File file: listofFiles){
                    if(file.getName().equals(leftNumber+".wav"))
                        file1 = file;
                    if(file.getName().equals("100.wav"))
                        file2 = file;
                }
                try {
                    AudioInputStream clip1 = AudioSystem.getAudioInputStream(file1);
                    AudioInputStream clip2 = AudioSystem.getAudioInputStream(file2);

                    AudioInputStream tempAppendFile = new AudioInputStream(new SequenceInputStream(clip1, clip2), clip1.getFormat(), clip1.getFrameLength() + clip2.getFrameLength());
                    appendFile = new AudioInputStream(new SequenceInputStream(appendFile, tempAppendFile), appendFile.getFormat(), appendFile.getFrameLength() + tempAppendFile.getFrameLength());

                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(firstNumber >= 1 && firstNumber <= 99){
                for(File file: listofFiles){
                    if(file.getName().equals(firstNumber+".wav"))
                        file1 = file;
                }
                try {
                    AudioInputStream clip1 = AudioSystem.getAudioInputStream(file1);
                    appendFile = new AudioInputStream(new SequenceInputStream(appendFile, clip1), appendFile.getFormat(), appendFile.getFrameLength() + clip1.getFrameLength());
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                AudioSystem.write(appendFile, AudioFileFormat.Type.WAVE, new File("generatedfiles/newfile.wav"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if(number >= 10000000 && number < 1000000000){
            int firstNumber = number / 10000000;

            File file1 = null;
            File file2 = null;

            AudioInputStream appendFiles = null;

            for(File file: listofFiles){
                if(file.getName().equals(firstNumber+".wav"))
                    file1 = file;
                if(file.getName().equals("10000000.wav"))
                    file2 = file;
            }
            try {
                AudioInputStream clip1 = AudioSystem.getAudioInputStream(file1);
                AudioInputStream clip2 = AudioSystem.getAudioInputStream(file2);

                appendFiles = new AudioInputStream(new SequenceInputStream(clip1, clip2), clip1.getFormat(), clip1.getFrameLength() + clip2.getFrameLength());
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int leftNumber = number % 10000000;
            firstNumber = leftNumber;

            if(leftNumber >= 100000 && leftNumber < 10000000){
                leftNumber = leftNumber / 100000;
                firstNumber = firstNumber % 100000;

                for(File file: listofFiles){
                    if(file.getName().equals(leftNumber+".wav"))
                        file1 = file;
                    if(file.getName().equals("100000.wav"))
                        file2 = file;
                }

                try {
                    AudioInputStream clip1 = AudioSystem.getAudioInputStream(file1);
                    AudioInputStream clip2 = AudioSystem.getAudioInputStream(file2);

                    AudioInputStream tempAppendFile = new AudioInputStream(new SequenceInputStream(clip1, clip2), clip1.getFormat(), clip1.getFrameLength() + clip2.getFrameLength());
                    appendFiles = new AudioInputStream(new SequenceInputStream(appendFiles, tempAppendFile), appendFiles.getFormat(), appendFiles.getFrameLength() + tempAppendFile.getFrameLength());

                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if(firstNumber >= 1000 && firstNumber < 100000){
                leftNumber = firstNumber / 1000;
                firstNumber = firstNumber % 1000;

                for(File file: listofFiles){
                    if(file.getName().equals(leftNumber+".wav"))
                        file1 = file;
                    if(file.getName().equals("1000.wav"))
                        file2 = file;
                }

                try {
                    AudioInputStream clip1 = AudioSystem.getAudioInputStream(file1);
                    AudioInputStream clip2 = AudioSystem.getAudioInputStream(file2);

                    AudioInputStream tempAppendFile = new AudioInputStream(new SequenceInputStream(clip1, clip2), clip1.getFormat(), clip1.getFrameLength() + clip2.getFrameLength());
                    appendFiles = new AudioInputStream(new SequenceInputStream(appendFiles, tempAppendFile), appendFiles.getFormat(), appendFiles.getFrameLength() + tempAppendFile.getFrameLength());
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(firstNumber >= 100 && firstNumber < 1000){
                leftNumber = firstNumber / 100;
                firstNumber = firstNumber % 100;

                for(File file: listofFiles){
                    if(file.getName().equals(leftNumber+".wav"))
                        file1 = file;
                    if(file.getName().equals("100.wav"))
                        file2 = file;
                }

                try {
                    AudioInputStream clip1 = AudioSystem.getAudioInputStream(file1);
                    AudioInputStream clip2 = AudioSystem.getAudioInputStream(file2);

                    AudioInputStream tempAppendFile = new AudioInputStream(new SequenceInputStream(clip1, clip2), clip1.getFormat(), clip1.getFrameLength() + clip2.getFrameLength());
                    appendFiles = new AudioInputStream(new SequenceInputStream(appendFiles, tempAppendFile), appendFiles.getFormat(), appendFiles.getFrameLength() + tempAppendFile.getFrameLength());

                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(firstNumber >=1 && firstNumber < 100){
                for(File file: listofFiles){
                    if(file.getName().equals(firstNumber+".wav"))
                        file1 = file;
                }

                try {
                    AudioInputStream clip1 = AudioSystem.getAudioInputStream(file1);

                    appendFiles = new AudioInputStream(new SequenceInputStream(appendFiles, clip1), appendFiles.getFormat(), appendFiles.getFrameLength() + clip1.getFrameLength());
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                AudioSystem.write(appendFiles, AudioFileFormat.Type.WAVE, new File("generatedfiles/newfile.wav"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //            appendFiles = new AudioInputStream(new SequenceInputStream(appendFiles, clipList.get(2)),
//                    appendFiles.getFormat(), appendFiles.getFrameLength() + clipList.get(2).getFrameLength());


    //   AudioInputStream  appendFiles = new AudioInputStream(new SequenceInputStream(clipList.get(0), clipList.get(1)),
//                    clipList.get(0).getFormat(), clipList.get(0).getFrameLength() + clipList.get(1).getFrameLength());
//            appendFiles = new AudioInputStream(new SequenceInputStream(appendFiles, clipList.get(2)),
//                    appendFiles.getFormat(), appendFiles.getFrameLength() + clipList.get(2).getFrameLength());
//
//            AudioSystem.write(appendFiles, AudioFileFormat.Type.WAVE, new File("/home/mijanur/IdeaProjects/wmvgenerator/generatedfiles/newfile.wav"));

    public static void main(String[] args){
        new Main();;
    }
}
