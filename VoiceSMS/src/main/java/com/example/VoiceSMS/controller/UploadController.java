package com.example.VoiceSMS.controller;

import com.example.VoiceSMS.model.PhoneNumber;
import com.example.VoiceSMS.model.WMVFile;
import com.example.VoiceSMS.repository.PhoneNumberRepository;
import com.example.VoiceSMS.service.PhoneNumberService;
import com.example.VoiceSMS.service.StorageService;
import com.example.VoiceSMS.service.WMVFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UploadController {

    @Autowired
    StorageService storageService;

    @Autowired
    PhoneNumberService phoneNumberService;

    @Autowired
    WMVFileService wmvFileService;

    List<String> files = new ArrayList<>();

    @GetMapping
    public ModelAndView loadUploadForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("uploadForm");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView handleFileUpload(@RequestParam("wmvfile")MultipartFile wmvfile, @RequestParam("csvfile") MultipartFile csvfile){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("uploadForm");
        try {
            int check = 0;
            for(String s: files){
                if(s.equals(wmvfile.getOriginalFilename())){
                    check = 1;
                }
            }

            if(check == 0){
                storageService.store(wmvfile);
                files.add(wmvfile.getOriginalFilename());
            }

            if(!wmvfile.isEmpty() && !csvfile.isEmpty()){
                modelAndView.addObject("message", "You have successfully uploaded file");
            }else {
                modelAndView.addObject("message1", "Please select file");
            }

        }catch (Exception e){

        }

        String fileName = wmvfile.getOriginalFilename();
        WMVFile wmvFile = new WMVFile(fileName);
        if(!fileName.equals(""))
        wmvFileService.add(wmvFile);

        File file = new File(csvfile.getOriginalFilename());
        try {
            if(file.exists()){
                file.createNewFile();

                FileOutputStream fos = new FileOutputStream(file);
                fos.write(csvfile.getBytes());
                fos.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(file.exists()){
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                String line;

                while ((line = randomAccessFile.readLine()) != null){
                    PhoneNumber phoneNumber = new PhoneNumber();
                    phoneNumber.setPhoneNumber(line);
                    phoneNumber.setWmvFile(wmvFile);
                    phoneNumberService.add(phoneNumber);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return modelAndView;
    }
}
