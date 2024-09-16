package com.codewithproject.springsecurity.store;

import com.codewithproject.springsecurity.entities.Channel;
import com.codewithproject.springsecurity.repository.ChannelRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * Store package: create Predicate
 * */
@Service
public class ChannelStore {

    @Autowired
    private ChannelRepository channelRepo;

    public List<Predicate> buildPredicateListChannel(CriteriaBuilder criteriaBuilder, Root<Channel> bladeRoot, String idChannel) {
        List<Predicate> rootPredicates = new ArrayList<>();

        if (idChannel != null && !idChannel.isEmpty() && !idChannel.trim().isEmpty()) {
            Predicate preChannel = criteriaBuilder.like(bladeRoot.get("idChannel"), idChannel);
            rootPredicates.add(preChannel);
        }
        return rootPredicates;
    }
}
