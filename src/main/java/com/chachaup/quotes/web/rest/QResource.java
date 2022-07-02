package com.chachaup.quotes.web.rest;

import com.chachaup.quotes.domain.Quote;
import com.chachaup.quotes.service.QService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequiredArgsConstructor @Slf4j @RequestMapping("/quotes")
public class QResource {
    private final QService qService;

    @GetMapping("/all")
    public List<Quote> all(){
        return qService.getAll();
    }

    @PostMapping("/save")
    public Quote save(Quote quote){
        return qService.add(quote);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) throws Exception {
        qService.deleteById(id);

    }
}
