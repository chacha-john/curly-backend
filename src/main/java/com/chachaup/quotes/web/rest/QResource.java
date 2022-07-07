package com.chachaup.quotes.web.rest;

import com.chachaup.quotes.domain.Quote;
import com.chachaup.quotes.service.QService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController @AllArgsConstructor
@Slf4j @RequestMapping("/quotes")
public class QResource {
    private final QService qService;

    @GetMapping("/all")
    public List<Quote> all(){
        List<Quote> quotes = new ArrayList<>();
        return qService.getAll();
    }

    @GetMapping("/{id}")
    public Quote findById(@PathVariable int id) throws Exception {
        log.info("request for quote with supplied id");
        return qService.findById(id);
    }

    @PostMapping("/save")
    public Quote save(@RequestBody Quote quote){
        return qService.add(quote);
    }

    @PatchMapping("/update/{id}")
    public Quote updateQuote(@RequestBody Quote quote, @PathVariable int id) throws Exception {
        return qService.update(quote, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) throws Exception {
        qService.deleteById(id);

    }
}
