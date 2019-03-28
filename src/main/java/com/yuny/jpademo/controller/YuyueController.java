package com.yuny.jpademo.controller;

import com.yuny.jpademo.pojo.yuyue;
import com.yuny.jpademo.repository.YuyueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class YuyueController {
    @Autowired
    private YuyueRepository yuyueRepository;

    @PostMapping(value = "/find")
    public List<yuyue> personListByName(@RequestBody String name) {
        return yuyueRepository.findByNameIsLike(name);
    }
    @PostMapping(value = "/all")
    public List<yuyue> getAll(@RequestBody String date) {
        return yuyueRepository.findByDatetimeLike(date);
    }
    @PostMapping("/del")
    public void personDelete(@RequestBody yuyue y) {
        yuyueRepository.delete(y);
    }
    @PostMapping(value = "/yuYue")
    public int yuYue(@RequestBody yuyue yy) {
        int s = 0;
        System.out.println(yy.getDatetime());
        yuyue dr = yuyueRepository.findByDatetimeAndRoom(yy.getDatetime(), yy.getRoom());
        yuyue dn = yuyueRepository.findByDatetimeAndName(yy.getDatetime(), yy.getName());
        if (dr != null) s = 1;
        else if (dn != null) s = 2;
        if (s == 0) yuyueRepository.save(yy);
        return s;
    }

    @PostMapping("/add")
    public yuyue addNewUser (@RequestBody yuyue n) {return yuyueRepository.save(n);}
}

