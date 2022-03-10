package com.example.makedatatest;

import com.example.makedatatest.model.Video;
import com.example.makedatatest.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@SpringBootApplication
public class MakeDataTestApplication {

    @Autowired
    @Lazy
    VideoRepository videoRepository;

    public static void main(String[] args) {
//        SpringApplication.run(MakeDataTestApplication.class, args);

        // create function to create data test
        System.out.println("a");
        System.out.println("This is line dev");
        System.out.println("sss");
        System.out.println("This is new line");
        System.out.println("This is line dev");
        System.out.println("This is line dev");
        System.out.println("This is line dev");
    }


    @EventListener(ApplicationReadyEvent.class)
    public void startApp() {
        List<Video> listVideo = videoRepository.findAll();
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("dataTest1.csv"));
            listVideo.forEach(video -> {
                String txt = video.getId() + "," + video.getTitle() + "," + video.getSeason() + "," + video.getStatus() + "," + video.getRating() + "\r\n";
                try {
                    dataOutputStream.write(txt.getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
