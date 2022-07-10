package com.chachaup.quotes.service;

import com.chachaup.quotes.domain.Quote;
import com.chachaup.quotes.repo.QRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service @Slf4j @AllArgsConstructor
public class QService {
    private final QRepo qRepo;

    //create operation in the CRUD
    public Quote add(Quote quote){
        log.info("About to save quote");
        qRepo.save(quote);
        log.info("quote saved successfully");
        return quote;
    }

    //read operation in the CRUD
    public List<Quote> getAll(){
        log.info("Requesting to get all quotes...");
        List<Quote> list = new ArrayList<>();

        Iterable<Quote> quoteIterable = qRepo.findAll();

        for (Quote quote : quoteIterable){
            list.add(quote);
        }
        log.info("Quotes populated successfully");
        return list;
    }

    public Quote findById(int id) throws Exception {
        log.info("request to find quote by supplied id");

        Optional<Quote> quoteOptional = qRepo .findById(id);
        if (quoteOptional.isPresent()){
            return quoteOptional.get();
        }
        else{
            throw new Exception("Quote does not exist");
        }
    }

    //update operation
    public Quote update(Quote quote, int id) throws Exception {
        log.info("requesting to update quote details");
        Optional<Quote> quoteOptional = qRepo.findById(id);
        if (quoteOptional.isPresent()){
            Quote quote1 = quoteOptional.get();
            quote1.setQuoteMessage(quote.getQuoteMessage());
            qRepo.save(quote1);
            return quote1;
        } else throw new Exception("Quote not found");
    }

    //delete operation
    public void deleteById(int id) throws Exception {
        log.info("requesting to delete quote by supplied id");
        Optional<Quote> quoteOptional = qRepo.findById(id);
        if (quoteOptional.isPresent()){
            qRepo.deleteById(id);
        }
        else{
            throw new Exception("Quote does not exist");
        }
    }
    public Quote randomQuote() throws Exception {
        log.info("Populating a quote...");
        List<Quote> quoteList = qRepo.findAll();
        if (quoteList.size()>0){
            return quoteList.get(getRandomNumber(0, quoteList.size()));
        }
        else {
            throw new Exception("There is no quote at this time");
        }

    }

    //helper methods
    public int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max-min)) + min);
    }

}
