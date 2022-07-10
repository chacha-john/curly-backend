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

    @PostMapping("/save")
    public Quote save(@RequestBody Quote quote){
        return qService.add(quote);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) throws Exception {
        qService.deleteById(id);

    }

    @GetMapping("/random")
    public Quote randomQuote() throws Exception {
        log.info("Request to return a random quote...");
        return qService.randomQuote();
    }
}
