package com.codewithproject.springsecurity.store;

import com.codewithproject.springsecurity.dto.logic.ChannelVideoLogicStore;
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

    public List<Predicate> buildPredicateListChannel(CriteriaBuilder criteriaBuilder, Root<Channel> channelRoot, ChannelVideoLogicStore req) {
        List<Predicate> rootPredicates = new ArrayList<>();
        String idChannel = req.getIdChannel();
        Integer fromSub = req.getFromSub();
        Integer toSub = req.getToSub();

        if (idChannel != null && !idChannel.isEmpty() && !idChannel.trim().isEmpty()) {
            Predicate preID = criteriaBuilder.like(channelRoot.get("idChannel"), idChannel);
            rootPredicates.add(preID);
        }
        if (fromSub != null) {
            Predicate preFromSub = criteriaBuilder.greaterThanOrEqualTo(channelRoot.get("subscribe"), fromSub);
            rootPredicates.add(preFromSub);
        }
        if (toSub != null) {
            Predicate preToSub = criteriaBuilder.lessThanOrEqualTo(channelRoot.get("subscribe"), toSub);
            rootPredicates.add(preToSub);
        }
        return rootPredicates;
    }
}
