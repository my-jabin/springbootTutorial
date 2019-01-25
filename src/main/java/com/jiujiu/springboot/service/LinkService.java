package com.jiujiu.springboot.service;

import com.jiujiu.springboot.model.Link;
import com.jiujiu.springboot.repo.LinkRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName LinkService
 * @AuThor yanbin.hu
 * @Date 1/22/2019
 * @Description
 **/
@Service
public class LinkService {

    private final LinkRepository linkRepository ;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Transactional
    public List<Link> findAll(){
        return this.linkRepository.findAll();
    }

    public Optional<Link> findById(long id){
        return this.linkRepository.findById(id);
    }


}